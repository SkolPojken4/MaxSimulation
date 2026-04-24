public class Customer extends Agent {

    private int[] targetPos;
    private Order order;

    public Customer() {
        super();
        this.targetPos = this.getPos();
    }

    public Customer(int[] pos) {
        super();
        this.targetPos = pos;
    }

    void setTarget(int[] pos) {
        this.targetPos = pos;
    }

    void update() {
        // Move towards targetPos
        if (this.getPos()[0] < targetPos[0]) {
            this.move(1, 0);
        } else if (this.getPos()[0] > targetPos[0]) {
            this.move(-1, 0);
        }

        if (this.getPos()[1] < targetPos[1]) {
            this.move(0, 1);
        } else if (this.getPos()[1] > targetPos[1]) {
            this.move(0, -1);
        }
    }

}
