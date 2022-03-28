package exceptions;

public class InvalidItemType extends Exception{
    public InvalidItemType(String className) {
        super("Bad item type: " + className);
    }
}
