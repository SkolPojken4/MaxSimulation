public class FoodItem {

    protected String name;
    protected OrderSystem.FoodType type;
    protected boolean isCooked;

    public FoodItem(String name, OrderSystem.FoodType type) {
        this.name = name;
        this.type = type;
        this.isCooked = false;
    }

    public OrderSystem.FoodType getType() { return this.type; }
    public void setCooked(boolean cooked) { this.isCooked = cooked; }
    public boolean isCooked() { return this.isCooked; }
}