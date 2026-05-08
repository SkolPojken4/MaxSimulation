import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantMain extends JPanel {

    static boolean startup = true;

    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static ArrayList<Waiter> waiters = new ArrayList<Waiter>();
    static ArrayList<Chef> chefs = new ArrayList<Chef>();
    static ArrayList<Table> tables = new ArrayList<Table>();
    static OrderSystem orderSystem = OrderSystem.getOrderSystem();
    static int windowWidth = 1200;
    static int windowHeight = 640;
    static ArrayList<OrderScreen> orderScreens = new ArrayList<OrderScreen>();
    // static MasterChef mChef;


    // In here all objects that are needed for operating the restaurant should be created.
    // This is initialisation and determines the initial state of the program.
    static void setupRestaurant(){
        customers.add(new Customer(new int[]{900, 200}));
        chefs.add(new Chef());
        waiters.add(new Waiter(600, 400));
        tables.add(new Table(new int[]{800, 200}));
        orderScreens.add(new OrderScreen(new int[]{800, 550}));

        customers.getFirst().setTargetScreen(orderScreens.getFirst());
    }

    // Contains the simulation logic, should probably be broken into smaller pieces as the program expands
    static void update() {

        for (Customer customer : customers) {
            customer.update();
        }

        for (Waiter w : waiters) {
            // w.update();
        }
        for (Chef c : chefs) {
            c.update();
        }

        // mChef.update();

        // ... similar updates for all other agents in the simulation.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // This method probably needs some functional decomposition...

        setBackground(new Color(255, 245, 158, 184)); //  // Set the background color to light yellow

        g.setColor(Color.DARK_GRAY); // Set the color for the borderlines
        g.drawRect(500, 0, 600, getHeight() - 5);
        //g.drawRect(800, 0, getWidth() - 5, getHeight() - 5);
        g.setColor(Color.BLACK);
        g.drawRect(500, 0, 695, getHeight() - 5);

        // Draw kitchen door
        g.setColor(Color.DARK_GRAY);
        g.fillRect(490, 270, 20, 100);
        g.fillRect(1090, 270, 20, 100);

        // Draw master chef office
        g.setColor(new Color(93, 191, 73, 255));
        g.fillRect(410, 200, 60, 200);

        // Draw the master chef
        g.setColor(Color.WHITE);
        g.fillOval(415, 270, 50, 50);
        // g.fillOval(mChef.getX(), mChef.getY(), mChef.getDiamter(), mChef.getDiamter());

        // Draw the chefs' workplaces
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 50, 150); // Prepchef
        g.fillRect(50, 0, 100, 50);
        g.fillRect(350, 50, 100, 100); // Garde Manger
        g.fillRect(450, 445, 50, 150); // Patissier
        g.fillRect(50, 300, 75, 200); // Sous chef

        // Draw tables
        drawTables(g);

        // Draw the waiters
        drawOrderScreens(g);

        // Draw the chefs
        drawChefs(g);

        // Draw the customers
        drawCustomers(g);
    }

    static void drawTables(Graphics g) {
        for (Table table : tables) {
            g.setColor(Color.RED);
            g.fillOval(table.getX(), table.getY(), table.getDiameter(), table.getDiameter()); // Draw circle with diameter of 50 pixels
            g.setColor(Color.WHITE);
            g.fillOval(table.getX()+3, table.getY()+3, table.getDiameter()-6, table.getDiameter()-6);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(1), table.getX()+30,  table.getY()+35);
        }
    }

    static  void drawOrderScreens(Graphics g){
        for (OrderScreen orderScreen : orderScreens) {
            g.setColor(Color.BLACK);
            g.fillRect(orderScreen.getX(), orderScreen.getY(), orderScreen.getWidth(), orderScreen.getHeight()); // Draw circle with diameter of 50 pixels
            g.setColor(Color.WHITE);
            g.fillRect(orderScreen.getX()+7, orderScreen.getY()+7, orderScreen.getWidth()-14, orderScreen.getHeight()-14); // Draw circle with diameter of 50 pixels
        }
    }

    static void drawChefs(Graphics g){
        for (Chef chef : chefs) {
            g.setColor(Color.GRAY);
            g.fillOval(300, 300, 60, 60); // Draw circle with diameter of 50 pixels
            g.setColor(Color.WHITE);
            g.fillOval(303, 303, 54, 54); // Draw circle with diameter of 50 pixels
            // g.fillOval(chef.getX()+3, chef.getY()+3, chef.getDiameter()-6, chef.getDiameter()-6); // Draw circle with diameter of 50 pixels
        }
    }

    static void drawCustomers(Graphics g){
        for (Customer c : customers) {
            int[] pos = c.getPos();

            g.setColor(Color.GRAY);
            g.fillOval(pos[0], pos[1], 60, 60); // Draw circle with diameter of 50 pixels
            g.setColor(Color.WHITE);
            g.fillOval(pos[0] + 3, pos[1] + 1, 54, 54); // Draw circle with diameter of 50 pixels
            // g.fillOval(chef.getX()+3, chef.getY()+3, chef.getDiameter()-6, chef.getDiameter()-6); // Draw circle with diameter of 50 pixels
        }
    }

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Restaurant Simulation");
        frame.setSize(windowWidth, windowHeight); // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Add the custom panel (with circles) to the frame
        RestaurantMain panel = new RestaurantMain();
        frame.add(panel);

        // Display the window
        frame.setVisible(true);

        // Setup for the restaurant
        setupRestaurant();

        while (true) {
            try {
                Thread.sleep(33); // With the goal of having about 30 fps.
            } catch (Exception threadException) {
                System.out.println("Sleep exception: " + threadException.getMessage());
            }
            update();
            panel.repaint();
        }
    }
}