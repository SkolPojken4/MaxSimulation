public class FoodItem {
    public enum CourseType {
        BURGER,
        DRINK,
        FRIES,
    }

    protected String name;
    protected CourseType type;
    protected boolean isCooked;

    public FoodItem(String name, CourseType type) {
        this.name = name;
        this.type = type;
        this.isCooked = false;
    }

    public CourseType getType() { return this.type; }
    public void setCooked(boolean cooked) { this.isCooked = cooked; }
    public boolean isCooked() { return this.isCooked; }
}