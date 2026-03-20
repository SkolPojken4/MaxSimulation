public class OrderScreen implements HasPosition {

    int[] pos;

    OrderScreen(int[] pos) {
        this.pos = pos;
    }

    public int[] getPos() {
        return this.pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

}
