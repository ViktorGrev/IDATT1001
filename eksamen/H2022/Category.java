import java.util.ArrayList;
import java.util.Collections;

/**
 * Enum for managing categories for items.
 *
 * @author 10023
 */
public enum Category
{
    /**
     * Floor laminate category.
     */
    FLOOR_LAMINATE(1, "Floor laminate"),
    /**
     * Window category.
     */
    WINDOW(2, "Window"),
    /**
     * Door category.
     */
    DOOR(3, "Door"),
    /**
     * Lumber category.
     */
    LUMBER(4, "Lumber");

    /**
     * Defining object variables.
     * No variables should be changed, and won't have any mutator methods for that reason.
     */
    private final int categoryNumber;
    private final String categoryName;

    /**
     * Instantiates a new Category.
     * Contains constructor for the class, with the information about the category.
     *
     * @param categoryNumber The given number for the category
     * @param categoryName The category name
     */
    Category(int categoryNumber, String categoryName)
    {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }

    /**
     * Gets category number.
     *
     * @return the category number
     */
    public int getCategoryNumber()
    {
        return categoryNumber;
    }

    /**
     * Gets category number.
     *
     * @return the category name
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * A method for getting the category enum.
     * Iterates through all the category enum values.
     * Checks each iteration if the categoryNumber from the parameter
     *  is equal to the category number in the enum.
     * If it's equals the category enum will be returned.
     * If no category has the specific category number,
     *  the program will throw a IllegalArgumentException to the user.
     *
     * @param categoryNumber the category number
     * @return the category name
     */
    public static Category getCategoryByCategoryNumber(int categoryNumber)
    {
        for (Category category : Category.values())
        {
            if (category.getCategoryNumber() == categoryNumber)
            {
                return category;
            }
        }
        throw new IllegalArgumentException("This category does not exist");
    }

    /**
     * A method to get all the categories in an ArrayList.
     * Creates a new ArrayList to contain all the categories.
     * Using the addAll method to add all the elements from Category
     *  to the specified collection (categoryList).
     *
     * @return A ArrayList with all the categories
     */
    public static ArrayList<Category> listOfCategoriesAndTheirValue()
    {
        ArrayList<Category> categoryList = new ArrayList<>();
        Collections.addAll(categoryList, Category.values());
        return categoryList;
    }
}