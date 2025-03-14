package dataStructure;

import org.example.dataStructure.tree.BST;
import org.example.dataStructure.tree.TreeNode;
import org.example.dataStructure.tree.TreeTraversal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TreeTest {
    //构造一颗树
    public TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null),
            1,
            new TreeNode(new TreeNode(5), 3, new TreeNode(6)));

    //构造一颗二叉搜索树
    BST.BSTNode<Integer,String> n1 = new BST.BSTNode<>(1, "d");
    BST.BSTNode<Integer,String> n3 = new BST.BSTNode<>(3, "e");
    BST.BSTNode<Integer,String> n2 = new BST.BSTNode<>(2, "b", n1, n3);
    BST.BSTNode<Integer,String> n5 = new BST.BSTNode<>(5, "f");
    BST.BSTNode<Integer,String> n7 = new BST.BSTNode<>(7, "g");
    BST.BSTNode<Integer,String> n6 = new BST.BSTNode<>(6, "c", n5, n7);
    BST.BSTNode<Integer,String> bstRoot = new BST.BSTNode<>(4, "a", n2, n6);

    @Test
    @DisplayName("二叉树递归遍历")
    public void treeTraversalRecursionTest() {
        System.out.print("preOrder:\t");
        TreeTraversal.preOrderRecursion(root);
        System.out.println();
        System.out.print("inOrder:\t");
        TreeTraversal.inOrderRecursion(root);
        System.out.println();
        System.out.print("postOrder:\t");
        TreeTraversal.postOrderRecursion(root);
        System.out.println();
        System.out.print("levelOrder:\t");
        TreeTraversal.levelOrderRecursion(root);
    }

    @Test
    @DisplayName("二叉树迭代遍历")
    public void treeTraversalIterativeTest() {
        System.out.print("preOrder:\t");
        TreeTraversal.preOrderIteration(root);
        System.out.println();
        System.out.print("inOrder:\t");
        TreeTraversal.inOrderIteration(root);
        System.out.println();
        System.out.print("postOrder:\t");
        TreeTraversal.postOrderIteration(root);
        System.out.println();
        System.out.print("levelOrder:\t");
        TreeTraversal.levelOrderIteration(root);
    }

    @Test
    @DisplayName("二叉搜索树get方法测试")
    public void binarySearchTreeTest() {
        BST<Integer,String> bst = new BST<>();
        bst.root = bstRoot;
        Assertions.assertEquals("d", bst.get(1));
        Assertions.assertEquals("g", bst.getIterative(7));
        Assertions.assertNull(bst.get(10));
        Assertions.assertNull(bst.getIterative(10));


    }

    @Test
    @DisplayName("二叉搜索树min|max|put方法测试")
    public void binarySearchTreeTest2() {
        BST<Integer,String> bst = new BST<>();
        bst.root = bstRoot;
        Assertions.assertEquals("d", bst.min());
        Assertions.assertEquals("g", bst.max());
        bst.put(0,"h");
        bst.put(8,"i");
        System.out.println(bst.min());
        System.out.println(bst.max());
        bst.delete(0);
        System.out.println(bst.min());
    }

    @Test
    @DisplayName("二叉搜索树successor|predecessor测试")
    public void binarySearchTreeTest3() {
        BST<Integer,String> bst = new BST<>();
        bst.root = bstRoot;
        System.out.println(bst.predecessor(3));
        System.out.println(bst.successor(3));

    }
}
