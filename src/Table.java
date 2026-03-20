public class Table {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    private int x;
    private int y;
    private int diameter = 80;

    Table(int x, int y){
        this.x = x;
        this.y = y;
    }



}
