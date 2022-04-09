// Java program to demonstrate
// insert operation in binary
// search tree
// encontrada en https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
// Hecha por GeeksforGeeks.org
// modificada para utilizar association por: Fabian Juarez
class BinarySearchTree{

    /**  Class containing left and right child of current node
     * and key value
     */
    class Node{

        association<String, String> palabra = new association<String,String>();
        Node left, right;
        // Constructor
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
    // Constructor
    BinarySearchTree(association<String, String> word) {
        root = new Node(word);
    }

    /**
     * @param word
     */
    // This method mainly calls insertRec()
    void insert(association<String, String> word) {
        root = insertRec(root, word);
    }


    /**
     * @param root
     * @param word
     * @return Node
     */
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


    /**
     * @param root
     */
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


    /**
     * @param word
     */
    void deleteKey(association<String, String> word){
        root = deleteRec(root, word);
    }

    /**
     * @param root
     * @param word
     * @return Node
     */
    /* A recursive function to delete an existing key in BST
     */
    Node deleteRec(Node root, association<String, String> word)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (word.getK().compareTo(root.palabra.getK())<0)
            root.left = deleteRec(root.left, word);
        else if (word.getK().compareTo(root.palabra.getK())>0)
            root.right = deleteRec(root.right, word);

        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            word = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, word);
        }

        return root;
    }

    /**
     * @param root
     * @return String
     */
    association<String, String> minValue(Node root)
    {
        association<String, String> minv = root.palabra;
        while (root.left != null)
        {
            minv = root.left.palabra;
            root = root.left;
        }
        return minv;
    }
  
     /**
     * @param word
     */
    String translateKey(String word){
        Node newNode= null;
        newNode = root;
        newNode = search(newNode, word);
        if(newNode==null){
            return word;
        }
        else{
            return newNode.palabra.getV();
        }
    }


    
    /** 
     * @param root
     * @param key
     * @return Node
     */
    public Node search(Node root, String key){
    // Base Cases: root is null or key is present at root
    if (root==null || root.palabra.getK().toUpperCase().compareTo(key.toUpperCase())==0)
        return root;

    // Key is greater than root's key
    if (root.palabra.getK().toUpperCase().compareTo(key.toUpperCase())<0)
       return search(root.right, key);

    // Key is smaller than root's key
    return search(root.left, key);
}
}
// This code is contributed by Ankur Narain Verma
