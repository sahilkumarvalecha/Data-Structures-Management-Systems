public class Order {
    int orderId;
    String dishName;
    int tableNumber;

    public Order(int orderId, String dishName, int tableNumber) {
        this.orderId = orderId;
        this.dishName = dishName;
        this.tableNumber = tableNumber;
    }

}
class Restaurant{
    Order[] circularQueue = new Order[5];
    int front = -1, rear = -1;
    int count = 0;

    public void newOrder(Order order){
        if((rear + 1) % circularQueue.length  == front) {
            System.out.println("Order Request full Can't take more");
            return;
        }
            if(front == -1 ){
                front++;
            }

        rear = (rear + 1)   % circularQueue.length;
        circularQueue[rear] = order;
        count++;
        }

    public void processOrders(){
        if(front == -1){
            System.out.println("No Pending Orders");
        }
            int current = front;
            Order order = circularQueue[current];
            System.out.println("Order Completed:");
            System.out.println("ID -> " + order.orderId + " Name: " + order.dishName + " Table Number: " + order.tableNumber);
            System.out.println();
            front++;
            count--;
    }
    public void displayPendingOrders(){
        if(front == -1){
            System.out.println("No Pending Orders");
        }
        int current = front;
        System.out.println("Pending Orders: ");
        for(int i = 0; i<count; i++){
            Order order = circularQueue[current];
            System.out.println("ID -> " + order.orderId + " Name: " + order.dishName + " Table Number: " + order.tableNumber);
            current = (current + 1) % circularQueue.length;
        }
    }
}
