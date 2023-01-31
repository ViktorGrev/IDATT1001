import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A class administrating an Item Register in a warehouse, with methods for an admin.
 *
 * @author 10023
 */
public class ItemRegister implements ItemRegisterInterface
{
    private HashMap<String, Item> itemInternalStorage; //itemInternalStorage

    /**
     * Instantiates a new item register.
     * Constructor for ItemRegister class
     * Creates a new hashmap
     * Initializing the register with data
     */
    public ItemRegister()
    {
        itemInternalStorage = new HashMap<>();
        testData();
    }

    /**
     * Instantiates a new Item register.
     * Constructor for ItemRegister class.
     * Creates a new hashmap with the information from the parameter.
     * Makes it easier for users to put in their own data
     * Used to also make the unit testing easier
     *
     * @param data Test data for using unit testing
     */
    public ItemRegister(HashMap<String, Item> data)
    {
        itemInternalStorage = data;
    }

    /**
     * Creates test data for the class.
     * Using registerItem method to put a new item in the itemInternalStorage(hashmap)
     */
    public void testData()
    {
        registerItem("PAX", "111", "IKEA", Category.DOOR,
                200, "A stable shelf", "WHITE", 156.1, 100.0, 50.0, 56, 0);
        registerItem("Flisberget", "222", "IKEA", Category.LUMBER,
                55, "Water proof", "RED", 10.1, 30.0, 55.0, 120, 0);
        registerItem("Mjol", "333", "IKEA", Category.LUMBER,
                140, "Safe roof", "BLACK", 12.1, 167.0, 52.0, 10, 0);
        registerItem("Jotun", "444", "IKEA", Category.LUMBER,
                135, "Roof range", "WHITE", 45.1, 41.0, 41.0, 500, 0);
        registerItem("Stabbur", "555", "IKEA", Category.WINDOW,
                135, "Soft cotton", "RED", 56.0, 178, 67.4, 21, 0);
        registerItem("King", "666", "IKEA", Category.WINDOW,
                135, "A stable chair", "WHITE", 145.0, 34.4, 40.0, 25, 0);
        registerItem("Labben", "777", "IKEA", Category.FLOOR_LAMINATE,
                135, "A cute teddy-bear", "BLACK", 120.6, 45.1, 41.0, 214, 0);
    }

    /**
     * Method for registering a new item.
     * Checks if the item already exists in the register
     * If it already exists, it will be thrown a IllegalArgumentException and will not proceed.
     * If it not already exist, an item will be created and will be registered
     *
     * @param itemName    The name of the item
     * @param itemNumber  An unique string for the item
     * @param brand       The brand that have designed the item
     * @param category    The category, an enum
     * @param price       The price
     * @param description The items description
     * @param color       The color
     * @param weight      The weight
     * @param length      The length
     * @param height      The height
     * @param units       The amount of units the storage have of the item
     * @param discount    The price discount in percent
     * @return Returning the newly registered item
     */
    public Item registerItem(String itemName, String itemNumber, String brand, Category category,
                             int price, String description, String color, double weight,
                             double length, double height, int units, double discount)
    {
        if (itemInternalStorage.containsKey(itemNumber))
        {
            throw new IllegalArgumentException("This item does already exist");
        }
        Item newItem = new Item(itemName, itemNumber, brand, category, price, description,
                color, weight, length, height, units, discount);
        itemInternalStorage.put(itemNumber, newItem);
        return newItem;
    }

    /**
     * A method for getting a deep copied version of an item by a specific item number.
     * Uses the getItemByItemNumber for better cohesion because of repetitive code
     *
     * @param itemNumber the item number
     * @return the item by item number copy
     */
    public Item getItemCopyByItemNumber(String itemNumber)
    {
        return new Item(getItemByItemNumber(itemNumber));
    }

    /**
     * A private method for getting an Item by giving an item number as input
     * Checks if the item number is invalid or if it exists.
     * If it is, the program will throw an IllegalArgumentException to the user
     * Getting the item by using the get method in the Map interface
     * The item number is the unique key in itemInternalStorage(hashmap)
     *  and is a fast method for getting the item (the value)
     *
     * @param itemNumber A item number.
     * @return Returning the item with the specific item number.
     * @throws IllegalArgumentException Throws when item number is not a key or an invalid string
     */
    private Item getItemByItemNumber(String itemNumber) throws IllegalArgumentException
    {
        if (itemNumber.isBlank())
        {
            throw new IllegalArgumentException("Invalid item number");
        }
        Item item = itemInternalStorage.get(itemNumber);
        if (item == null)
        {
            throw new IllegalArgumentException("Item does not exist");
        }
        return item;
    }

    /**
     * A method for changing the amount of units an item has in the storage.
     * The changeUnits() method takes two arguments:
     *  a String called itemNumber that represents the item number of the item to be modified,
     *   and an int called amount that represents the number of units to add or remove from the
     *    item.
     *
     * @param itemNumber     the item number
     * @param amount The amount to increase
     */
    public void changeUnits(String itemNumber, int amount) throws IllegalArgumentException
    {
        Item itemToIncrease = getItemByItemNumber(itemNumber);
        itemToIncrease.setUnits(amount);
    }

    /**
     * A method for removing a specific item in the register.
     * The specified key is the item number that will come from the parameter.
     * Removes the mapping for the specified key from this map if present.
     *
     * @param itemNumber An item number
     */
    public void deleteItem(String itemNumber) throws IllegalArgumentException
    {
        checkIfStorageContainsItemNumber(itemNumber);
        itemInternalStorage.remove(itemNumber);
    }

    /**
     * Sets a new price for the item. Checks if the price is valid
     *
     * @param itemNumber the item number
     * @param newPrice   the new price
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void changePrice(String itemNumber, int newPrice)
    {
        getItemByItemNumber(itemNumber).setPrice(newPrice);
    }

    /**
     * Sets a new description for the item. Checks if the new description is valid
     *
     * @param itemNumber     the item number
     * @param newDescription the new description
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void changeDescription(String itemNumber, String newDescription)
    {
        getItemByItemNumber(itemNumber).setDescription(newDescription);
    }

    /**
     * Sets a new discount.
     * First, the method retrieves the Item object with the given item number
     *  using the getItemByItemNumber() method.
     * Then, it uses the setDiscount() method to set the Item object's discount
     *  to the new discount specified as an argument to the changeDiscount() method.
     * This will change the discount of the Item object with the given item number.
     *
     * @param itemNumber  the item number
     * @param newDiscount the new discount
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void changeDiscount(String itemNumber, double newDiscount)
    {
        getItemByItemNumber(itemNumber).setDiscount(newDiscount);
    }

    /**
     * This helping method checks if the itemInternalStorage map contains an Item
     *  object with a given item number.
     * If the Item does not exist in the map, it throws an IllegalArgumentException with
     *  the message "This item does not exist".
     *
     * @param itemNumber The item number to the item.
     * @throws IllegalArgumentException Throws an IllegalArgumentException if the item doesn't exist
     */
    private void checkIfStorageContainsItemNumber(String itemNumber) throws IllegalArgumentException
    {
        if (!itemInternalStorage.containsKey(itemNumber))
        {
            throw new IllegalArgumentException("This item does not exist");
        }
    }

    //------------Extra----------------------------------------------------------------------------

    /**
     * This code retrieves a list of Item objects that belong to a given Category and
     *  sorts them by their itemName property in ascending order.
     * The getItemsByCategory() method takes a Category object as an argument and returns
     *  an ArrayList of Item objects that belong to that category.
     * To do this, it first creates an empty ArrayList called itemsInCategory.
     * It then iterates over the items in the itemInternalStorage map, which maps item
     *  numbers to Item objects.
     * For each Item object in the map, it checks if the Category of the Item matches
     *  the Category specified as an argument to the getItemsByCategory() method.
     * If the Category matches, it adds a copy of the Item to the itemsInCategory list using
     *  the add() method.
     * After all the items in the itemInternalStorage map have been processed, the
     *  getItemsByCategory() method sorts the itemsInCategory list using the sortItemsByName()
     *   method and returns the sorted list.
     *
     * @param category The category number
     * @return Returns a sorted list of items with a specific category
     */
    public ArrayList<Item> getItemsByCategory(Category category)
    {
        ArrayList<Item> itemsInCategory = new ArrayList<>(); // empty arraylist for the copy

        itemInternalStorage.forEach((itemNumber, item) ->
        {
            if (category == item.getCategory())
            {
                itemsInCategory.add(new Item(item));
            }
        });
        return sortItemsByName(itemsInCategory);
    }

    /**
     * This method sorts a list of Item objects in alphabetical order by their itemName property.
     * The ArrayList class in Java provides a sort() method that can be used to sort the list.
     * The sort() method takes a Comparator object that specifies the sorting criteria.
     * In this case, the Comparator object is created using the comparing() method of the
     *  Comparator class, which takes a Function that specifies how to extract the sort key
     *   from each Item object.
     * In this case, the sort key is the itemName property, and the getItemName() method is
     *  used to extract the property from each Item object.
     * The Comparator object is then passed to the sort() method, which sorts the list in
     *  ascending order according to the itemName property of the Item objects.
     *   Finally, the sorted list is returned.
     *
     * @param itemsToSort An ArrayList that will be sorted.
     * @return Returning a sorted list
     */
    private ArrayList<Item> sortItemsByName(ArrayList<Item> itemsToSort)
    {
        itemsToSort.sort(Comparator.comparing(Item::getItemName));
        return itemsToSort;
    }

    /**
     * This is a helper method used to sort a list of Item objects in ascending order of price.
     * The method takes in an ArrayList named itemsToSort that contains the items to be sorted.
     * The method uses the sort() method from the ArrayList class, along with a Comparator to sort
     *  the items by price.
     * This Comparator uses the getPrice() method to compare the prices of each item, so that they
     *  are sorted in ascending order of price.
     * Finally, the sorted itemsToSort list is returned.
     *
     * @param itemsToSort An ArrayList that will be sorted.
     * @return Returning a sorted list
     */
    private ArrayList<Item> sortItemsByPrice(ArrayList<Item> itemsToSort)
    {
        itemsToSort.sort(Comparator.comparing(Item::getPrice));
        return itemsToSort;
    }

    /**
     * This is a method for retrieving a subset of items from the hashmap on a given price range.
     * The method takes in two integer values, minPrice and maxPrice, which represent the minimum
     *  and maximum price.
     * If either of these values is less than 0, the method will throw an IllegalArgumentException.
     * The method also declares an empty ArrayList named itemsInPriceRange that will hold copies of
     *  the items that fall within the given price range.
     * The method uses a forEach loop to iterate through each item in the itemInternalStorage list.
     * For each item, the price is retrieved using the getPrice() method and checked against the
     *  given price values.
     * If the price falls within the given price range, a new Item object with a copy of the item
     *  is added to the itemsInPriceRange list.
     * Finally, the itemsInPriceRange list is returned after it has been sorted in ascending order
     *  of price using the sortItemsByPrice() method.
     *
     * @param minPrice the min price
     * @param maxPrice the max price
     * @return the array list
     */
    public ArrayList<Item> itemsInPriceRange(int minPrice, int maxPrice)
            throws IllegalArgumentException
    {
        if (minPrice < 0 || maxPrice < 0)
        {
            throw new IllegalArgumentException("The price must be a positive integer");
        }
        ArrayList<Item> itemsInPriceRange = new ArrayList<>(); // empty arraylist for the copy

        itemInternalStorage.forEach((itemNumber, item) ->
        {
            int itemPrice = item.getPrice();
            if (itemPrice >= minPrice && itemPrice <= maxPrice)
            {
                itemsInPriceRange.add(new Item(item));
            }
        });
        return sortItemsByPrice(itemsInPriceRange);
    }

    /**
     * This code provides an implementation of the iterator() method of the Iterator interface.
     * This method returns an Iterator object that can be used to iterate over the items in the
     *  itemInternalStorage map.
     * The iterator() method first creates an empty ArrayList called itemStorageCopy.
     * It then iterates over the items in the itemInternalStorage map and adds a copy of each
     *  Item object to the itemStorageCopy list using the add() method.
     * After all the items in the itemInternalStorage map have been processed, the iterator()
     *  method sorts the itemStorageCopy list using the sortItemsByName() method and returns an
     *   Iterator object for the sorted list using the iterator() method of the ArrayList class.
     * This Iterator object can be used to iterate over the Item objects in the itemInternalStorage
     *  map in ascending order by their itemName property.
     * The reason of this method is that the main file will not need to change if I
     *  were to for example change from a Hashmap to a Hashset or an ArrayList because it would
     *   still return an iterator.
     *
     * @return An iterator of all the items in the hashmap
     */
    @Override
    public Iterator<Item> iterator()
    {
        ArrayList<Item> itemStorageCopy = new ArrayList<>(); // empty arraylist for the copy
        itemInternalStorage.forEach((itemNumber, item) -> itemStorageCopy.add(new Item(item)));
        return sortItemsByName(itemStorageCopy).iterator();
    }
}
