import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library l = new Library();
        Scanner scanner = new Scanner(System.in);
        l.addBook(new Book("Hyper Focus", "Chris Bailey", 5));
        l.addBook(new Book("it Ends With Us", "Collen Hoover", 3));
        l.addBook(new Book("Apocalypse", "Zombies", 1));

        l.displayBooks();
        while (true) {
                System.out.println("Enter The Book Title: ");
                String title = scanner.nextLine();
                Book currBook = l.searchBook(title);
                if (currBook == null) {
                    System.out.println("No Book With Such Title");
                    break;
                }
            while (true) {
                System.out.println("Do You want to Borrow Or Return?");
                System.out.println("1)Borrow");
                System.out.println("2)Return");
                System.out.println("3)Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        l.borrowBook(currBook.title);
                        break;
                    case 2:
                        l.returnBook(currBook.title);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Input!");
                }
            }
        }
}
}
