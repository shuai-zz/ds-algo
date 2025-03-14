package org.example.dataStructure.tree;

public class BST<K extends Comparable<K>, V> {


    public static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    public BSTNode<K, V> root; //根节点


    /**
     * 根据关键字查找关键值
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return doGet(key, root);
    }

    private V doGet(K key, BSTNode<K, V> node) {
        if (node == null || key == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return doGet(key, node.left); //向左找
        else if (cmp > 0) return doGet(key, node.right); //向右找
        else return node.value;
    }

    /**
     * 迭代实现get方法
     *
     * @param key
     * @return
     */
    public V getIterative(K key) {
        if (key == null) return null;
        BSTNode<K, V> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node.value;
        }
        return null;
    }


    /**
     * 查找最小关键字对应的值
     *
     * @return
     */
    public V min() {
        return min(root);
    }

    /**
     * 查找最大关键字对应的值
     *
     * @return
     */
    public V max() {
        return max(root);
    }


    public void put(K key, V value) {
        BSTNode<K, V> node = root;
        BSTNode<K, V> parent = null;
        while (node != null) {
            parent = node;
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else {
                //key存在，更新value
                node.value = value;
                return;
            }
        }
        //若该树为空
        if (parent == null) {
            root = new BSTNode<>(key, value);
            return;
        }
        //key不存在，新增
        if (key.compareTo(parent.key) < 0) {
            parent.left = new BSTNode<>(key, value);
        } else {
            parent.right = new BSTNode<>(key, value);
        }
    }

    public V successor(K key) {
        BSTNode<K, V> node = root;
        BSTNode<K, V> ancestor = null;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                ancestor = node;
                node = node.left;
            } else if (cmp > 0) node = node.right;
            else break;
        }
        //没找到节点
        if (node == null) return null;
        //找到节点
        if (node.right != null) return min(node.right);
        return ancestor != null ? ancestor.value : null;
    }

    private V min(BSTNode<K, V> node) {
        if (node == null) return null;
        BSTNode<K, V> p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    public V predecessor(K key) {
        BSTNode<K, V> node = root;
        BSTNode<K, V> ancestor = null;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) {
                ancestor = node;
                node = node.right;
            } else break;
        }
        if (node == null) return null;
        if (node.left != null) return max(node.left);
        return ancestor != null ? ancestor.value : null;
    }

    private V max(BSTNode<K, V> node) {
        if (node == null) return null;
        BSTNode<K, V> p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    public void delete(K key) {
        BSTNode<K, V> node = root;
        BSTNode<K, V> parent = null;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                parent = node;
                node = node.left;
            } else if (cmp > 0) {
                parent = node;
                node = node.right;
            } else break;
        }
        if (node == null) return;

        //删除操作
        if (node.left == null) {
            //没有左孩子
            shift(parent,node,node.right);
        } else if (node.right == null) {
            //没有右孩子
            shift(parent,node,node.left);
        }else{
            BSTNode<K,V> s=node.right;
            BSTNode<K,V> sParent=node;
            while (s.left != null) {
                sParent = s;
                s=s.left;
            }
            if(sParent!=node){
                shift(sParent,s,s.right);
                s.right=node.right;
            }
            shift(parent,node,s);
            s.left=node.left;
        }
    }

    private void shift(BSTNode<K, V> parent,BSTNode<K,V> deleted,BSTNode<K, V> child) {
        if(parent==null) root=child;
        else if (deleted==parent.left) {
            parent.left = child;
        }else{
            parent.right=child;
        }
    }

    public V deleteRecursively(K key) {
        root=doDelete(root,key);
        return root.value;
    }
    private BSTNode<K,V> doDelete(BSTNode<K,V> node,K key) {
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left=doDelete(node.left,key);
            return node;
        }
        if (cmp > 0) {
            node.right=doDelete(node.right,key);
            return node;
        }

        if(node.left==null){
            return node.right;
        }
        if(node.right==null){
            return node.left;
        }

        BSTNode<K,V> s=node.right;
        while(s.left!=null){
            s=s.left;
        }

        s.right = doDelete(node.right, s.key);
        s.left=node.left;
        return s;
    }
}
