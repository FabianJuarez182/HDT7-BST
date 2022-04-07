// Java program to demonstrate
// insert operation in binary
// search tree
// encontrada en https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
// Hecha por GeeksforGeeks.org
class BinarySearchTree{

    /**  Class containing left and right child of current node
     * and key value
     */
    class Node{

        association<String, String> palabra = new association<String,String>();
        Node left, right;

        public Node(association<String, String> word)
        {
            palabra = word;
            left = right = null;
        }

    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(association<String, String> word) {
        root = new Node(word);
    }

    // This method mainly calls insertRec()
    void insert(association<String, String> word) {
        root = insertRec(root, word);
    }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, association<String, String> word)
    {
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(word);
            return root;
        }

        /* Otherwise, recur down the tree */
        if(word.getK().compareTo(root.palabra.getK())==0){
            root.palabra = word;
        }
        else{
            if (word.getK().compareTo(root.palabra.getK())<0)
                root.left = insertRec(root.left, word);
            else{
                root.right = insertRec(root.right, word);
            }
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.palabra.getK() + "->" + root.palabra.getV());
            inorderRec(root.right);
        }
    }
}
// This code is contributed by Ankur Narain Verma
