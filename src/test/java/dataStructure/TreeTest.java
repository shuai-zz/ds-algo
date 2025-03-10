package dataStructure;

import org.example.dataStructure.tree.TreeNode;
import org.example.dataStructure.tree.TreeTraversal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TreeTest {
    //构造一颗树
    public TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null),
            1,
            new TreeNode(new TreeNode(5), 3, new TreeNode(6)));

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
}
