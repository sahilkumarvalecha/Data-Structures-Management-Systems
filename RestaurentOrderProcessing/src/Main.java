public class Main {
    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        r.newOrder(new Order(1,"Pasta",7));
        r.newOrder(new Order(2,"Pizza",3));
        r.newOrder(new Order(3,"Roti",5));

        r.processOrders();
        r.displayPendingOrders();
    }
}