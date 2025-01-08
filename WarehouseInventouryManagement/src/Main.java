import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Scanner scanner = new Scanner(System.in);
        w.addItem(new Item("Biscuit",20));
        w.addItem(new Item("Shampoo",2));
        w.addItem(new Item("Hair Brush",10));
        w.addItem(new Item("Cold Drink",50));

        w.displayItems();
        System.out.print("Enter name of item you want to update stock for: ");
        String title = scanner.nextLine();
        System.out.println();
        System.out.print("Enter Stock of item : ");
        int stock = scanner.nextInt();
        w.addStock(title,stock);
    }
}