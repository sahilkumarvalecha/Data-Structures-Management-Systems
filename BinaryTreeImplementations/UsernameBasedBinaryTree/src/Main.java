public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        String firstName = "Sahil";
        String lastName = "Valecha";
        String username = firstName+lastName;

        for(int i=0; i<username.length();i++){
            char a = username.charAt(i);
            bt.insert(a);
        }
        bt.inOrder();
    }
}