package tree;

import java.util.LinkedList;

/**
 * @author yjx
 * @date 2019/12/11
 **/
public class BST<K extends Comparable<K>, V> {

    private Node root;
    private int count;

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        int result = node.key.compareTo(key);
        if (result == 0) {
            node.value = value;
        } else if (result > 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public V search(K key) {
        return search(root, key);
    }

    private V search(Node node, K key) {
        if (node == null) {
            return null;
        }
        int result = node.key.compareTo(key);
        if (result == 0) {
            return node.value;
        } else if (result > 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.key);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key);
    }

    public void levelOrder() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            Node node = list.remove();
            System.out.print(node.key);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }
}
