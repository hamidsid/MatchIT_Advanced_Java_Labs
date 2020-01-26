package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
    BinaryNode<E> root;
    int size;

    /**
     * Constructs an empty binary searchtree.
     */
    public BinarySearchTree() {
        size = 0;
    }

    /**
     * Inserts the specified element in the tree if no duplicate exists.
     *
     * @param x element to be inserted
     * @return true if the the element was inserted
     */
    public boolean add(E x) {

        //if root is null then add the element directly
        if (root == null) {
            root = new BinaryNode<E>(x);
            size++;
            return true;
        }

        return add(root, x);
    }

    private boolean add(BinaryNode<E> node, E x) {

        //check if value is same with the root
        if (x.compareTo(node.element) == 0) {
            return false;
        }

        //if value is smaller than root, then recurse for left tree
        else if (x.compareTo(node.element) < 0) {
            if (node.left == null) {
                node.left = new BinaryNode<>(x);
                size++;
                return true;
            } else {
                return add(node.left, x);
            }
        } else if (x.compareTo(node.element) > 0) {
            if (node.right == null) {
                node.right = new BinaryNode<>(x);
                size++;
                return true;
            } else {
                return add(node.right, x);
            }
        }
        return false;
    }

    /**
     * Computes the height of tree.
     *
     * @return the height of the tree
     */
    public int height() {
        return calculateHeight(root);
    }

    /**
     * Recursively calculates the depths of the right and left subtree
     *
     * @param node the current node being checked
     * @return max value of left and right subtree depths.
     */

    private int calculateHeight(BinaryNode<E> node) {
        if (node == null)
            return 0;

        int lHeight = calculateHeight(node.left);
        int rHeight = calculateHeight(node.right);
        return 1 + Math.max(lHeight, rHeight);
    }

    /**
     * Returns the number of elements in this tree.
     *
     * @return the number of elements in this tree
     */
    public int size() {
        return size;
    }

    /**
     * Print tree contents in inorder.
     */
    public void printTree() {
        print_inOrder(root);
    }

    private void print_inOrder(BinaryNode<E> node) {
        if (node != null) {
            print_inOrder(node.left);
            System.out.print(node.element + " ");
            print_inOrder(node.right);
        }
    }

    /**
     * Builds a complete tree from the elements in the tree.
     */
    public void rebuild() {

        if (size < 1)
            System.out.println("The tree is empty");

        E[] a = (E[]) new Comparable[size];
        int last = toArray(root, a, 0);
        System.out.println("lenght is" + last);
        root = buildTree(a, 0, last - 1);


    }

    /*
     * Adds all elements from the tree rooted at n in inorder to the array a
     * starting at a[index].
     * Returns the index of the last inserted element + 1 (the first empty
     * position in a).
     */
    private int toArray(BinaryNode<E> n, E[] a, int index) {
        if (n == null)
            return index;

        index = toArray(n.left, a, index);   // first do every left child tree
        a[index++] = n.element;          // then write the data in the array
        return toArray(n.right, a, index);  // do the same with the right child
    }

    /*
     * Builds a complete tree from the elements a[first]..a[last].
     * Elements in the array a are assumed to be in ascending order.
     * Returns the root of tree.
     */
    private BinaryNode<E> buildTree(E[] a, int first, int last) {

        // Base Case
        if (first > last)
            return null;

        // Get the middle element and make it root(middleNode)
        int mid = (first + last) / 2;
        BinaryNode<E> middleNode = new BinaryNode<>(a[mid]);

        // create the left and right tree recursively
        middleNode.left = buildTree(a, first, mid - 1);
        middleNode.right = buildTree(a, mid + 1, last);

        return middleNode;
    }


    static class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;

        private BinaryNode(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for (int i = 1; i < 15; i += 2) {
            bst.add(i);
        }
        bst.printTree();
        BSTVisualizer bstVisualizer = new BSTVisualizer("Tree Drawn", 600, 400);
        System.out.println("rebuilted then printed");
        bst.rebuild();
        bst.printTree();
        bstVisualizer.drawTree(bst);


    }

}
