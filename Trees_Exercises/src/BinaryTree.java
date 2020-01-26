public class BinaryTree<E> {

    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Writes out the tree in the pre order
     */
    public void print_preOrder() {
        print_preOrder(root);
    }

    private void print_preOrder(Node<E> n) {
        if (n != null) {
            System.out.print(n.data + ", ");
            print_preOrder(n.left);
            print_preOrder(n.right);
        }
    }

    /**
     * Writes out the tree in the pre order
     */
    public void print_postOrder() {
        print_postOrder(root);
    }

    private void print_postOrder(Node<E> n) {
        if (n != null) {
            print_postOrder(n.left);
            print_postOrder(n.right);
            System.out.print(n.data);
        }
    }

    /**
     * Writes out the tree in the pre order
     */
    public void print_inOrder() {
        print_inOrder(root);
    }

    private void print_inOrder(Node<E> n) {
        if (n != null) {
            print_inOrder(n.left);
            System.out.print(n.data);
            print_inOrder(n.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        BinaryTree.Node<String> r = new Node<String>("F");
        r.left = new Node<>("B");
        r.left.left = new Node<>("A");
        r.left.right = new Node<>("D");
        r.left.right.left = new Node<>("C");
        r.left.right.right = new Node<>("E");
        r.right = new Node<>("G");
        r.right.right = new Node<>("I");
        r.right.right.left = new Node<>("H");

        binaryTree.root = r;

        System.out.println("--------------Pre Order--------------------");
        binaryTree.print_preOrder();
        System.out.println();


        System.out.println();
        System.out.println("--------------Post Order--------------------");
        binaryTree.print_postOrder();
        System.out.println();



        System.out.println();
        System.out.println("--------------In Order--------------------");
        binaryTree.print_inOrder();
        System.out.println();


    }
}
