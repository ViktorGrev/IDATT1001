import java.util.ArrayList;
import java.util.Iterator;

interface  ItemRegisterInterface extends Iterable<Item>
{

    Item registerItem(String itemName, String itemNumber, String brand, Category category,
                      int price, String description, String color, double weight,
                      double length, double height, int units, double discount);

    Item getItemCopyByItemNumber(String itemNumber);

    void changeUnits(String itemNumber, int increaseAmount);

    void deleteItem(String itemNumber);

    ArrayList<Item> getItemsByCategory(Category categoryNumber);

    ArrayList<Item> itemsInPriceRange(int minPrice, int maxPrice);

    void changePrice(String itemNumber, int newPrice);

    void changeDescription(String itemNumber, String newDescription);

    void changeDiscount(String itemNumber, double newDiscount);

    Iterator<Item> iterator();
}
