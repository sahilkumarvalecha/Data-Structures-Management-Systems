public class Main {
    public static void main(String[] args) {
    BInaryTree bt = new BInaryTree();

    String productCode = "12B72J02YA";

    for(int i=0; i<productCode.length();i++){
        bt.insert(productCode.charAt(i));
    }

    bt.preOrder();
    System.out.println("Searching: ");
    bt.search('7');
    System.out.println("After Insertion And Deletion:");
    bt.delete('2');
    bt.insert('8');
    bt.preOrder();
    }
}