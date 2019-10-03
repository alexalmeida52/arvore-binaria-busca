package br.com.waldson.aula11;

public class ArvoreBinariaBusca {
    public Node getRaiz() {
        return raiz;
    }

    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public int getHeight(Node node){
        int left, right;
        if(node == null) return -1;
        left = getHeight(node.getLeft());
        right = getHeight(node.getRight());


        if (left > right) {
            return left+1;
        } else {
            return right+1;
        }

    }

    public boolean isBalanced(Node node){
        int hl = 0;
        int hr = 0;
        if (node == null ) return true;
        if(node.getLeft() != null){
            hl = getHeight(node.getLeft()) + 1;
        }
        if(node.getRight() != null){
            hr = getHeight(node.getRight()) + 1;
        }
        if (Math.abs(hr - hl) < 2){
            return isBalanced(node.getLeft()) && isBalanced(node.getRight());
        } else {
            return false;
        }
    }

    public Node getRoot() {
        return raiz;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

    public Node remover(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.getValue()) {
            node.setLeft(remover(node.getLeft(), key));
        }
        else if (key > node.getValue()) {
            node.setRight(remover(node.getRight(), key));
        }

        else if (node.getLeft() != null || node.getRight() != null){
            node.setValue(node.encontraMinimo(node.getRight()).getValue());
            node.setRight(node.removeMinimo(node.getRight()));
        }
        else {
            node = (node.getLeft() == null) ? node.getLeft() : node.getRight();
        }
        return node;
    }

}
