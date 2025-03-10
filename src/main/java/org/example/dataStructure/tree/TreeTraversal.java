package org.example.dataStructure.tree;

import java.util.*;

import static org.example.ColorPrint.*;

public class TreeTraversal {

    //递归实现前、中、后序遍历、层序遍历
    public static void preOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        //访问节点值
        System.out.print(root.value + "\t");
        //访问左子节点
        preOrderRecursion(root.left);
        //访问右子节点
        preOrderRecursion(root.right);
    }

    public static void inOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left);
        System.out.print(root.value + "\t");
        inOrderRecursion(root.right);
    }

    public static void postOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.value + "\t");
    }

    public static void levelOrderRecursion(TreeNode root) {
        var res=new ArrayList<List<Integer>>();
        DFS(root, 0,res);
        for(var level:res){
            for(var val:level){
                System.out.print(val+"\t");
            }
        }
    }
    private static void DFS(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        //初始化该层数组
        if(level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.value);
        DFS(root.left,level+1,res);
        DFS(root.right,level+1,res);
    }

    //迭代实现前、中、后序遍历

    public static void preOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode popped = null;//最近一次弹栈的元素
        while(!stack.isEmpty()||curr != null) {
            if(curr != null) {
                stack.push(curr);
                colorPrint(String.valueOf(curr.value),RED);
                //待处理左子树
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right==null) {//没有右子树
                    popped = stack.pop();
                }else if(peek.right==popped){//右子树处理完成
                    popped = stack.pop();
                }else{//待处理右子树
                    curr = peek.right;
                }
            }
        }

    }

    public static void inOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode popped = null;//最近一次弹栈的元素
        while(!stack.isEmpty()||curr != null) {
            if(curr != null) {
                stack.push(curr);
                //待处理左子树
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right==null) {//没有右子树
                    colorPrint(String.valueOf(peek.value),GREEN);
                    popped = stack.pop();
                }else if(peek.right==popped){//右子树处理完成
                    popped = stack.pop();
                }else{//待处理右子树
                    colorPrint(String.valueOf(peek.value),GREEN);
                    curr = peek.right;
                }
            }
        }
    }

    public static void postOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode popped = null;//最近一次弹栈的元素
        while(!stack.isEmpty()||curr != null) {
            if(curr != null) {
                stack.push(curr);
                //待处理左子树
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right==null) {//没有右子树
                    popped = stack.pop();
                    colorPrint(String.valueOf(popped.value),BLUE);
                }else if(peek.right==popped){//右子树处理完成
                    popped = stack.pop();
                    colorPrint(String.valueOf(popped.value),BLUE);
                }else{//待处理右子树
                    curr = peek.right;
                }
            }
        }
    }

    public static void levelOrderIteration(TreeNode root) {
        var res=new ArrayList<List<Integer>>();
        BFS(root,res);
        for(var level:res){
            for(var val:level){
                colorPrint(String.valueOf(val),PURPLE);
            }
        }
    }
    private static void BFS(TreeNode root, List<List<Integer>> res) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            var level=new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node=queue.poll();
                level.add(node.value);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add(level);
        }
    }



}

