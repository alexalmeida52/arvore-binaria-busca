package br.com.waldson.aula11;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }

    public Node removeMinimo(Node node) {
        if (node == null) {
        } else if (node.getLeft() != null) {
            node.setLeft(removeMinimo(node.getLeft()));
            return node;
        } else {
            return node.getRight();
        }
        return null;
    }

    public Node encontraMinimo(Node node) {
        if (node != null) {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        }
        return node;
    }
}
