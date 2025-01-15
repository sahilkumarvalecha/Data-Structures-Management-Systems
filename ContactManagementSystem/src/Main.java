import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactBook cb = new ContactBook();
        Scanner scanner = new Scanner(System.in);
        cb.addContact(new Contact("Sahil", "sahilvalecha95@gmail.com", 0314));
        cb.addContact(new Contact("Sandesh", "docOak@gmail.com", 026));
        cb.addContact(new Contact("Mahkash", "mahkash64@gmail.com", 0314));
        cb.addContact(new Contact("bhavesh", "bhavesh36@gmail.com", 0314));

        cb.displayContacts();
        while (true) {
            System.out.println("1)Update Email");
            System.out.println("2)Update Phone Number");
            System.out.println("3)Exit");
            int choice = scanner.nextInt();
            System.out.println("Enter Your Name: ");
            String name = scanner.nextLine();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Your Email: ");
                    String email = scanner.nextLine();
                    cb.updateEmail(name, email);
                    System.out.println("Success");
                    cb.searchContact(name);
                    break;
                case 2:
                    System.out.println("Enter Your Phone Number");
                    int number = scanner.nextInt();
                    cb.updatePhone(name, number);
                    System.out.println("Success");
                    cb.searchContact(name);

                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}