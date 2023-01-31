import java.util.function.Consumer;

/**
 * A class for managing a menu.
 * As of JDK 14, we can replace our repetitious data classes with records.
 * Records are immutable data classes that require only the type and name of fields.
 * This record, is the same as a class with:
 * <ul>
 *     <li> private, final field for each piece of data </li>
 *     <li> getter for each field </li>
 *     <li> public constructor with a corresponding argument for each field </li>
 *     <li> equals method that returns true for objects of the same class when all fields
 *          match </li>
 *     <li> hashCode method that returns the same value when all fields match </li>
 *     <li> toString method that includes the name of the class and the name of each field and
 *  *      its corresponding value </li>
 * </ul>
 *
 * @param option The option that the user has
 * @param method Consumer is a functional interface and can therefore be used
 *               as the assignment target for a lambda expression or method reference.
 *  @author 10023
 */
public record MenuItem(String option, Consumer<Integer> method) {}


