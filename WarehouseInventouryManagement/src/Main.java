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
        while(true) {
            System.out.println("1) Update Stock");
            System.out.println("2) View Stock");
            System.out.println("3) Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter Stock of item : ");
                    int stock = scanner.nextInt();
                    w.addStock(title, stock);
                    break;
                case 2:
                    w.DisplayStock(title);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

    }
}