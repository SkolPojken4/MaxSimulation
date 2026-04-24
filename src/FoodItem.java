public class FoodItem {

    protected String name;
    protected FoodType type;
    protected boolean isCooked;

    public FoodItem(String name,FoodType type) {
        this.name = name;
        this.type = type;
        this.isCooked = false;
    }

    public FoodType getType() { return this.type; }
    public void setCooked(boolean cooked) { this.isCooked = cooked; }
    public boolean isCooked() { return this.isCooked; }
}