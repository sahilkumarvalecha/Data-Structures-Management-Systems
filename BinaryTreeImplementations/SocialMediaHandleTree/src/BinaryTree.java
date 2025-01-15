class Node{
    char data;
    Node left,right;

    public Node(char data) {
        this.data = data;
    }
}

public class BinaryTree {
    Node root;

    public void insert(char data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, char data) {
        if (root == null) {
            root = new Node(data);
        } else if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inOrder(){
        inOrderRec(root);
    }
    public void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(" " +  root.data);
            inOrderRec(root.right);
        }
    }

    public void search(char Target){
        System.out.println(searchRec(root,Target,""));
    }
    public String searchRec(Node root,char Target, String path){
        if(root == null){
            return "false";
        }
        if(root.data == Target){
            return root.data + "Found At: " + path;
        }
        else if(Target < root.data){
            return searchRec(root.left,Target,path + "L");
        }
        else if(Target > root.data){
            return searchRec(root.right,Target,path + "R");
        }
        return "false";
    }

    public void delete(char target){
        root = deleteRec(root,target);
    }
    public Node deleteRec(Node root,char target){
        if (root == null) {
            return null;
        }
        if (target < root.data) {
            root.left = deleteRec(root.left, target);
        }
        else if (target < root.data) {
            root.right = deleteRec(root.right, target);
        }
        else {
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return null;
    }
    public char minValue(Node root){
        char minVal = root.data;
        while(root.left != null){
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }
}
