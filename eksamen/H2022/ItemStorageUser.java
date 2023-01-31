import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A class to represent the text based user interface of the application.
 * This class makes use of the Scanner-class to get input from the
 *   ser via the terminal.
 *
 * @author 10023
 */
public class ItemStorageUser
{
    private final Scanner sc;
    private final ItemRegisterInterface itemRegister;

    /**
     * Instantiates a new Item storage user
     * Creates a Scanner for the input from user in the terminal.
     * Loading the different menu choices and actions for the user
     */
    public ItemStorageUser()
    {
        sc = new Scanner(System.in);
        itemRegister = new ItemRegister();
        loadMenuItems();
        loadChangeItems();
    }

    /**
     * The entry point of application.
     * Starts the program by showing the menu to the user
     *
     * @param args Commandline arguments as an array of String
     */
    public static void main(String[] args)
    {
        ItemStorageUser main = new ItemStorageUser();
        main.showMenu();
    }

    /**
     * Hashmap to contain the menus, instead of e.g. a switch case
     */
    private final HashMap<Integer, MenuItem> menuChoiceDict = new HashMap<>();
    private final HashMap<Integer, MenuItem> menuChangeDict = new HashMap<>();

    /**
     * Puts in the different options in the start menu.
     */
    private void loadMenuItems()
    {
        menuChoiceDict.put(0,
                new MenuItem("Exit", (index)  -> exitProgram()));
        menuChoiceDict.put(1,
                new MenuItem("Show all items in storage", (index) -> showAllItems()));
        menuChoiceDict.put(2,
                new MenuItem("Get item by item number", (index) -> showItemByItemNumber()));
        menuChoiceDict.put(3,
                new MenuItem("Increase units for an item", (index) -> increaseUnits()));
        menuChoiceDict.put(4,
                new MenuItem("Decrease units for an item", (index) -> decreaseUnits()));
        menuChoiceDict.put(5,
                new MenuItem("Add a new item to the storage", (index) -> addItem()));
        menuChoiceDict.put(6,
                new MenuItem("Remove an item from the storage", (index) -> deleteItem()));
        menuChoiceDict.put(7,
                new MenuItem("Get all items in a price rage", (index) -> showItemsInPriceRange()));
        menuChoiceDict.put(8,
                new MenuItem("Get items in a specific category", (index) -> showItemsInCategory()));
        menuChoiceDict.put(9,
                new MenuItem("Change the property to an item", (index) -> changeItemProperties()));
    }

    /**
     * Puts in the options in the menuChangeDict (hashmap) for changing an item.
     */
    private void loadChangeItems()
    {
        menuChangeDict.put(1,
                new MenuItem("Change the price", (index) -> changePriceForItem()));
        menuChangeDict.put(2,
                new MenuItem("Change the description", (index) -> changeDescriptionForItem()));
        menuChangeDict.put(3,
                new MenuItem("Change the discount", (index) -> changeDiscountForItem()));
    }

    /**
     * A method to get the method that the user has chosen.
     * Gets the input from the user, by calling the getMenuChoice method.
     * If it's a valid choice, the method to that choice will proceed the program.
     * If it's not a valid choice, the user will get an ERROR and the user can try again.
     * The try-catch will catch errors (e.g. NumberFormatExeption or IlligalArguemtExeption)
     *  and print the given error message from a thrown error.
     */
    private void showMenu()
    {
        boolean quit = false;
        while (!quit)
        {
            try
            {
                int menuItemChoice = getMenuChoice(menuChoiceDict);
                if (menuChoiceDict.containsKey(menuItemChoice))
                {
                    menuChoiceDict.get(menuItemChoice).method().accept(menuItemChoice);
                } else
                {
                    System.out.println("Unrecognized menu choice selected..");
                }

            } catch (NumberFormatException e)
            {
                System.out.println(e.getMessage() + " Input must match the variable type");
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage() + " Invalid input");
            }
        }
    }

    /**
     * A method to get the users choice in a menu.
     *
     * @param menuChoices All the different options for the user
     * @return The users choice
     */
    private int getMenuChoice(HashMap<Integer, MenuItem> menuChoices)
    {
        System.out.println("\n");
        menuChoices.forEach(
                (key, menuItem) -> System.out.println(key + " = " + menuItem.option()));
        System.out.println("Please choose menu item with the given integer");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * A method to present all the items in the register
     * By using iterable in the register, I only have to iterate through the instance
     *  of the register, and not a specified list or map.
     */
    private void showAllItems()
    {
        for (Item item : itemRegister)
        {
            System.out.println(item);
        }
    }

    /**
     * A method to show a specific item.
     */
    private void showItemByItemNumber()
    {
        System.out.println("Write the item number for the specific item you want to see");
        String itemNumber = sc.nextLine();
        Item item = itemRegister.getItemCopyByItemNumber(itemNumber);
        System.out.println(item);
    }

    /**
     * A method to increase the amount of units a specific item has in a register.
     */
    private void increaseUnits()
    {
        System.out.println("What item do you want to increase units to \n Type the item number: ");
        String itemNumber = sc.nextLine();
        System.out.println("How many units do you want to increase for the item?");
        int increaseAmount = Integer.parseInt(sc.nextLine());
        if (increaseAmount < 0)
        {
            throw new IllegalArgumentException("The amount can not be under 0");
        }
        itemRegister.changeUnits(itemNumber, increaseAmount);
        System.out.println("Item " + itemNumber + " has now "
                + itemRegister.getItemCopyByItemNumber(itemNumber).getUnits() + " total units");
    }

    /**
     * A method to decrease the amount of units a specific item has in a register.
     */
    private void decreaseUnits()
    {
        System.out.println("For what item do you want to decrease units to. \n "
                + "Type the item number: ");
        String itemNumber = sc.nextLine();
        System.out.println("How many units do you want to decrease for the item? \n "
                + "Enter a positive value: ");
        int decreaseAmount = Integer.parseInt(sc.nextLine());
        if (decreaseAmount < 0)
        {
            throw new IllegalArgumentException("The amount can not be under 0");
        }
        itemRegister.changeUnits(itemNumber, decreaseAmount * -1);
        System.out.println("Item " + itemNumber + " has now "
                + itemRegister.getItemCopyByItemNumber(itemNumber).getUnits() + " total units");

    }

    /**
     * A method to add a new item to the storage.
     */
    private void addItem()
    {
        System.out.println("Item name as a string:");
        String itemName = sc.nextLine();
        System.out.println("Item number as a string:");
        String itemNumber = sc.nextLine();
        System.out.println("Brand as a string:");
        String brand = sc.nextLine();
        System.out.println("Category:");
        System.out.println(printListOfCategories(Category.listOfCategoriesAndTheirValue()));
        System.out.println("Please pick a category in this list by referring to the given number");
        int categoryNumber = Integer.parseInt(sc.nextLine());
        Category category = Category.getCategoryByCategoryNumber(categoryNumber);
        System.out.println("Price as an integer:");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Description as a string:");
        String description = sc.nextLine();
        System.out.println("Color as a string:");
        String color = sc.nextLine();
        System.out.println("Weight as an double (kg):");
        double weight = Double.parseDouble(sc.nextLine());
        System.out.println("Length as an double(cm):");
        double length = Double.parseDouble(sc.nextLine());
        System.out.println("Height as an double(cm):");
        double height = Double.parseDouble(sc.nextLine());
        System.out.println("Amount of units as integer:");
        int units = Integer.parseInt(sc.nextLine());
        int discount = 0;
        Item newItem = itemRegister.registerItem(itemName, itemNumber, brand, category, price,
                description, color, weight, length, height, units, discount);
        System.out.println("You have just registered: \n" + newItem);
    }

    /**
     * A method to delete/remove a specific item from the register.
     */
    private void deleteItem()
    {
        System.out.println("What item do you want to remove \n Type the item number: ");
        String itemNumber = sc.nextLine();
        itemRegister.deleteItem(itemNumber);
        System.out.println("The item has been removed");
    }

    /**
     * A method to find all the items in the register in a given price range.
     */
    private void showItemsInPriceRange()
    {
        System.out.println("Minimum price");
        int price1 = Integer.parseInt(sc.nextLine());
        System.out.println("Max price");
        int price2 = Integer.parseInt(sc.nextLine());
        int minPrice = Math.min(price1, price2);
        int maxPrice = Math.max(price1, price2);
        System.out.println(printListOfItems(
                itemRegister.itemsInPriceRange(minPrice, maxPrice)));
    }

    /**
     * A method to get all the items in a specific category.
     */
    private void showItemsInCategory()
    {
        System.out.println("What category do you want to show?");
        System.out.println(printListOfCategories(Category.listOfCategoriesAndTheirValue()));
        System.out.println("Please choose menu item with the given integer.");
        int categoryNumber = Integer.parseInt(sc.nextLine());
        Category category = Category.getCategoryByCategoryNumber(categoryNumber);
        System.out.print(
                printListOfItems(itemRegister.getItemsByCategory(category)));
    }

    /**
     * A method to change a specific item property.
     * Using the getMenuChoice method to get the user choice
     * Gets the method for the specific option that the user picked
     */
    private void changeItemProperties()
    {
        int userChangeChoice = getMenuChoice(menuChangeDict);
        if (menuChangeDict.containsKey(userChangeChoice))
        {
            menuChangeDict.get(userChangeChoice).method().accept(userChangeChoice);
        } else
        {
            System.out.println("Unrecognized menu choice selected..");
        }
    }

    /**
     * A method for changing the item price.
     */
    private void changePriceForItem()
    {
        System.out.println("For what item do you want to change the price for? \n "
                + "Type the item number: ");
        String itemNumber = sc.nextLine();
        System.out.println("What do you want set the new price to?");
        int newPrice = Integer.parseInt(sc.nextLine());
        itemRegister.changePrice(itemNumber, newPrice);
        System.out.println("The price has now been changed to " + newPrice);
    }

    /**
     * A method for changing the item description.
     */
    private void changeDescriptionForItem()
    {
        System.out.println("For what item do you want to change the description for? \n "
                + "Type the item number: ");
        String itemNumber = sc.nextLine();
        System.out.println("What do you want set the new discount to?");
        String newDescription = sc.nextLine();
        itemRegister.changeDescription(itemNumber, newDescription);
        System.out.println("The description has now changed");
    }

    /**
     * A method for changing the item price.
     */
    private void changeDiscountForItem()
    {
        System.out.println("For what item do you want to change the discount for? \n "
                + "Type the item number: ");
        String itemNumber = sc.nextLine();
        System.out.println("What do you want set the new discount to?");
        System.out.println("Type in the discount in decimal from 1 to 0");
        double newDiscount = Double.parseDouble(sc.nextLine());
        itemRegister.changeDiscount(itemNumber, newDiscount);
        System.out.println("The item does now have " +  (newDiscount * 100) + "% discount");
    }

    /**
     * A method to exit the program
     * Using the exit method to exit the program.
     * The call System.exit(n) is effectively equivalent to the call:
     *   Runtime.getRuntime().exit(n)
     */
    private void exitProgram()
    {
        System.out.println("The system has been exited");
        System.exit(0);
    }

    /**
     * A helping method to get a string of all the items in a given ArrayList.
     * Checks if the given ArrayList is empty.
     * If it is, returning a string that contains a error message.
     * If the list contains items, the program will proceed.
     * Creates a StringBuilder to hold on the string that will be built.
     * Iterating through the list of items using Iterator.
     * As long as the iterator has more elements, the while loop is true.
     * Each iteration an item will be added as a string in the StringBuilder
     *
     * @param listOfItems A list of items
     * @return Returning a String of all the items in the given ArrayList
     */
    private String printListOfItems(ArrayList<Item> listOfItems)
    {
        if (listOfItems.isEmpty())
        {
            return "No results or invalid input \n";
        }
        StringBuilder listedItems = new StringBuilder();
        Iterator<Item> iteratedItems = listOfItems.iterator();
        while (iteratedItems.hasNext())
        {
            listedItems.append(iteratedItems.next());
        }

        return listedItems.toString();
    }

    /**
     * * A helping method to get a string of all the categories in a given ArrayList.
     * Checks if the given ArrayList is empty
     * If it is, returning a string that contains a error message.
     * If the list contains categories, the program will proceed.
     * Creates a StringBuilder to hold on the string that will be built.
     * Iterating through the list of categories using Iterator.
     * As long as the iterator has more elements, the while loop is true.
     * Each iteration a category will be added as a string in the StringBuilder.
     *
     * @param listOfCategories A list of categories
     * @return Returning a String of all the categories in the given ArrayList
     */
    private String printListOfCategories(ArrayList<Category> listOfCategories)
    {
        if (listOfCategories.isEmpty())
        {
            return "No results or invalid input \n";
        }
        StringBuilder allCategories = new StringBuilder();
        Iterator<Category> iteratedItems = listOfCategories.iterator();
        while (iteratedItems.hasNext())
        {
            Category category = iteratedItems.next();
            allCategories.append(category.getCategoryNumber()).append(" = ")
                .append(category.getCategoryName()).append("\n");
        }
        return allCategories.toString();
    }
}
