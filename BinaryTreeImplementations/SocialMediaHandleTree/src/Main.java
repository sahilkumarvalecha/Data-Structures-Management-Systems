public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        String socialMedia = "@sahil_valecha";

        for(int i=0; i<socialMedia.length();i++){
            bt.insert(socialMedia.charAt(i));
        }

        bt.inOrder();
        bt.search('a');
        bt.delete('@');
        bt.inOrder();

    }
}