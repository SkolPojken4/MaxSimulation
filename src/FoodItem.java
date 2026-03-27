public class FoodItem {
    public enum CourseType {
        BURGER,
        DRINK,
        FRIES,
    }

    private String name;
    private CourseType type;
    private boolean isCooked = false;

    public FoodItem(String name, CourseType type) {
        this.name = name;
        this.type = type;
    }

    public CourseType getType() { return type; }
    public void setCooked(boolean cooked) { this.isCooked = cooked; }
    public boolean isCooked() { return isCooked; }
}