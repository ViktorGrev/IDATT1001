/**
 * A class representing an item.
 *
 * @author 10023
 */
public class Item
{
    /**
     * Defining object variables.
     * Some variables will be changed, and will have mutator methods for that reason
     * final will be given to the variables that will not change
     */
    private final String itemName;
    private final String itemNumber;
    private final String brand;
    private final Category category; //Uses Category(Enum) instead of int for more functionality
    private int price;
    private String description;
    private final String color;
    private final double weight;
    private final double length;
    private final double height;
    private int units;
    private double discount;

    /**
     * Instantiates a new Item.
     * Contains constructor for the class, with the information about an item.
     * Checks every variable to see if it is valid (e.g. weight cant be less than 0).
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
     */
    public Item(String itemName, String itemNumber, String brand, Category category, int price,
                String description, String color, double weight, double length, double height,
                int units, double discount)
    {
        if (units < 0)
        {
            throw new IllegalArgumentException("Invalid number of units");
        }
        if (price < 0)
        {
            throw new IllegalArgumentException("The price cannot be less than 0.");
        }
        if (weight <= 0)
        {
            throw new IllegalArgumentException("The weight of the item cannot be less than 0 kg.");
        }
        if (length <= 0)
        {
            throw new IllegalArgumentException("The length of the item cannot be less than 0 .");
        }
        if (height <= 0)
        {
            throw new IllegalArgumentException("Invalid height");
        }
        if (discount < 0 || discount > 1)
        {
            throw new IllegalArgumentException("Invalid discount");
        }

        //Taking use of isBlank() and not isEmpty() because isBlank() also sees
        // if there is only whitespace.
        //isBlank() checks if the string is blank, empty or contains only white spaces.
        if (itemName.isBlank())
        {
            throw new IllegalArgumentException("You have not specified a name.");
        }
        if (itemNumber.isBlank())
        {
            throw new IllegalArgumentException("Invalid item number");
        }
        if (brand.isBlank())
        {
            throw new IllegalArgumentException("Invalid brand");
        }
        if (description.isBlank())
        {
            throw new IllegalArgumentException("Invalid description");
        }
        if (color.isBlank())
        {
            throw new IllegalArgumentException("You have not specified a color.");
        }

        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.description = description;
        this.color = color;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.units = units;
        this.discount = discount;
    }

    /**
     * A second constructor for constructing deep copies.
     * This makes the program have looser coupling.
     *
     * @param item The item that want to deep copy
     */
    public Item(Item item)
    {
        this(item.getItemName(), item.getItemNumber(), item.getBrand(), item.getCategory(),
                item.getPrice(), item.getDescription(), item.getColor(), item.getWeight(),
                item.getLength(), item.getHeight(), item.getUnits(), item.getDiscount());
    }

    /**
     * Gets the item name.
     *
     * @return the item name
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Gets the item number.
     *
     * @return the item number
     */
    public String getItemNumber()
    {
        return itemNumber;
    }

    /**
     * Gets the item brand.
     *
     * @return the brand
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Gets the category that the item is in.
     *
     * @return the category
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * Gets the price for the item.
     *
     * @return the price
     */
    public int getPrice()
    {
        return (int) Math.round(price * (1 - getDiscount()));
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Gets the weight.
     *
     * @return the weight
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public double getLength()
    {
        return length;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Gets the amount of units.
     *
     * @return the units
     */
    public int getUnits()
    {
        return units;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public double getDiscount()
    {
        return discount;
    }

    /**
     * A method for change the amount of units there are of an item in the storage.
     * The setUnits() method takes an int argument called amount that represents the number
     *  of units to add or remove from the Item object.
     * If the amount argument is negative, the method will remove units from the Item object.
     * If the amount argument is positive, the method will add units to the Item object.
     *
     * @param amount the amount
     */
    public void setUnits(int amount)
    {
        if (amount < units * -1)
        {
            throw new IllegalArgumentException("Invalid amount to expunge");
        }
        this.units += amount;
    }

    /**
     * Sets a new price for the item.
     * Checks if the price is valid
     *
     * @param price the price
     */
    public void setPrice(int price)
    {
        if (price < 0)
        {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    /**
     * Sets a new description for the item.
     * Checks if the new description is valid
     *
     * @param newDescription the new description
     */
    public void setDescription(String newDescription)
    {
        if (newDescription.isBlank())
        {
            throw new IllegalArgumentException("The description cant be blank");
        }
        this.description = newDescription;
    }

    /**
     * Sets a discount.
     * Checks if the discount is a valid value
     *
     * @param discount the discount
     */
    public void setDiscount(double discount)
    {
        if (discount < 0 || discount > 1)
        {
            throw new IllegalArgumentException(
                    "Invalid discount, discount must be a double from 1 to 0");
        }
        this.discount = discount;
    }

    /**
     * Overriding the to string method to print the object in a user-friendly way.
     *
     * @return object as a defined string
     */
    @Override
    public String toString()
    {
        return "Item name: " + getItemName() + '\n'
                + "Item number: " + getItemNumber() + '\n'
                + "Brand: " + getBrand() + '\n'
                + "Category: " + getCategory().getCategoryName() + '\n'
                + "Price: " + getPrice() + '\n'
                + "Description: " + getDescription() + '\n'
                + "Weight: " + getWeight() + '\n'
                + "Height: " + getHeight() + '\n'
                + "Length: " + getLength() + '\n'
                + "In storage: " + getUnits() + '\n' + '\n';
    }
}
