class Node{
    char data;
    Node left;
    Node right;

    public Node(char data){
        this.data = data;
    }
}
public class BinaryTree {
    Node root;


    public void insert(char data ){
        root = inserRec(root, data);
    }

    public Node inserRec(Node root,char data){
        if(root == null){
            root = new Node(data);
        }
        else if( data < root.data){
            root.left = inserRec(root.left,data);
        }
        else {
            root.right = inserRec(root.right,data);
        }
        return root;
    }

    public void inOrder(){
        inOrderRec(root);
    }
    public void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);

        }
    }

    public void search(char target){
        searchRec(root,target, " ");
    }
    public String searchRec(Node root,char target, String path){
        if(root == null){
            return "false";
        }
        if(target == root.data){
            return root.data + "Found At " + path;
        }
        else if(target < root.data){
            return searchRec(root.left,target,path + 'L');
        }
        else{
            return searchRec(root.right,target, path + 'R');
        }
    }

    public void delete(char target){
        deleteRec(root,target);
    }
    public Node deleteRec(Node root,char target){
        if(root == null){
            return null;
        }
        else if(target < root.data){
            root.left = deleteRec(root.left,target);
        }
        else if(target > root.data){
            root.right = deleteRec(root.right,target);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRec(root.right,target);
        }
        return root;
    }

    public char minValue(Node root){
        char minVal = (char) root.data;
        while(root.left != null){
            minVal = (char) root.left.data;
            root = root.left;
        }
        return minVal;
    }


}
