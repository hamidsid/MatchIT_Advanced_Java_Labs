

import static org.junit.jupiter.api.Assertions.*;

import bst.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
    BinarySearchTree<Integer> tree;

    @BeforeEach
    public void init() {
        tree = new BinarySearchTree<Integer>();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(4);
    }

    @Test
    void EmptyTree() {
        tree = new BinarySearchTree<Integer>();
        assertEquals(tree.size(), 0);
        assertEquals(tree.height(), 0);
    }

    @Test
    void NonEmptyTree() {
        assertTrue(tree.add(111));
        assertFalse(tree.add(1));
        assertEquals(tree.size(), 6);
    }

    @Test
    void TestPrint() {
        System.out.println("1 2 3 4 5");
        tree.printTree();
    }
}