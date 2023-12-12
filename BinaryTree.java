//package Estrutura_Dados.Arvore;
//
//class Node{
//    int value;
//    Node left, right;
//
//    public Node(int value){
//        this.value = value;
//        this.left = this.right = null;
//    }
//}
//public class BinaryTree {
//    Node source;
//    public BinaryTree(){
//        this.source = null;
//    }
//
//    // ADICIOAR VALORES À ÁRVORE
//    private Node setRec(Node node, int value){
//        if (node == null){
//            return new Node(value);
//        }
//        if (value < node.value) {
//            node.left = setRec(node.left, value);
//        } else if (value > node.value) {
//            node.right = setRec(node.right, value);
//        }
//        return node;
//    }
//
//
//    public void setNumber(int value){
//        source = setRec(source, value);
//    }
//
//
//    //BUSCAR ELEMENTO
//    private boolean searchRec(Node node, int value){
//        if(node == null){
//            return false;
//        }
//        if (value == node.value){
//            return true;
//        } else if (value < node.value){
//            return searchRec(node.left, value);
//        }
//        return searchRec(node.right, value);
//    }
//
//    public boolean search(int value){
//        return searchRec(source, value);
//    }
//
//    //EXIBIR EM ORDEM
//    private void displayInOrder(Node node){
//        if(node != null){
//            displayInOrder(node.left);
//            System.out.print(node.value + " ");
//            displayInOrder(node.right);
//        }
//    }
//
//    public void display() {
//        displayInOrder(source);
//        System.out.println();
//    }
//
//    // REMOVER ELEMENTO
//    public void remove(int value) {
//        source = removeRec(source, value);
//    }
//
//    private Node removeRec(Node root, int value) {
//        if (root == null) {
//            return null;
//        }
//
//        if (value < root.value) {
//            root.left = removeRec(root.left, value);
//        } else if (value > root.value) {
//            root.right = removeRec(root.right, value);
//        } else {
//
//            if (root.left == null) {
//                return root.right;
//            } else if (root.right == null) {
//                return root.left;
//            }
//
//            root.value = minValue(root.right);
//
//            root.right = removeRec(root.right, root.value);
//        }
//
//        return root;
//    }
//
//    private int minValue(Node root) {
//        int minValue = root.value;
//        while (root.left != null) {
//            minValue = root.left.value;
//            root = root.left;
//        }
//        return minValue;
//    }
//
//    // CONTAGEM NO NÚMERO DE FOLHAS
//    public int countLeaves() {
//        return countLeavesRec(source);
//    }
//
//    private int countLeavesRec(Node node) {
//        if (node == null) {
//            return 0;
//        }
//
//        if (node.left == null && node.right == null) {
//            return 1;
//        }
//
//        int leftLeaves = countLeavesRec(node.left);
//        int rightLeaves = countLeavesRec(node.right);
//
//        return leftLeaves + rightLeaves;
//    }
//
//    // VERIFICAR SE É UMA ÁRVORE BST
//    public boolean isBST() {
//        return isBSTUtil(source, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    private boolean isBSTUtil(Node node, int min, int max) {
//        // Caso base: uma árvore vazia é uma BST
//        if (node == null) {
//            return true;
//        }
//
//        if (node.value < min || node.value > max) {
//            return false;
//        }
//
//        return isBSTUtil(node.left, min, node.value - 1) && isBSTUtil(node.right, node.value + 1, max);
//    }
//
//    // SOMAR O VALOR DO NÓ E AS SOMAS RECURSIVAS DAS ÁRVORES
//    private int sumRec(Node node) {
//        if (node == null) {
//            return 0;
//        }
//        return node.value + sumRec(node.left) + sumRec(node.right);
//    }
//    public int sum() {
//        return sumRec(source);
//    }
//    private void displayPreOrderRec(Node node) {
//        if (node != null) {
//            System.out.print(node.value + " ");
//            displayPreOrderRec(node.left);
//            displayPreOrderRec(node.right);
//        }
//    }
//
//    public void displayPreOrder() {
//        displayPreOrderRec(source);
//        System.out.println();
//    }
//
//    private void displayPostOrderRec(Node node) {
//        if (node != null) {
//            displayPostOrderRec(node.left);
//            displayPostOrderRec(node.right);
//            System.out.print(node.value + " ");
//        }
//    }
//
//    public void displayPostOrder() {
//        displayPostOrderRec(source);
//        System.out.println();
//    }
//
//}
//class Main {
//    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//
//        int[] value = {10, 5, 15, 3, 7, 12, 20};
//        for (int value1 : value) {
//            tree.setNumber(value1);
//        }
//
//        System.out.println("Árvore em pré-ordem:");
//        tree.displayPreOrder();
//
//        System.out.println("Árvore em ordem:");
//        tree.display();
//
//        System.out.println("Árvore em pós-ordem:");
//        tree.displayPostOrder();
//
//        int valueFind = 7;
//        if (tree.search(valueFind)) {
//            System.out.println("O valor " + valueFind + " está presente na árvore.");
//        } else {
//            System.out.println("O valor " + valueFind + " não está presente na árvore.");
//        }
//
//        int valueToRemove = 15;
//        tree.remove(valueToRemove);
//
//        System.out.println("Árvore após a remoção do valor " + valueToRemove + ":");
//        tree.display();
//
//        int leavesCount = tree.countLeaves();
//        System.out.println("Número de folhas na árvore: " + leavesCount);
//
//        if (tree.isBST()) {
//            System.out.println("A árvore é uma árvore binária de busca.");
//        } else {
//            System.out.println("A árvore NÃO é uma árvore binária de busca.");
//        }
//
//        int sum = tree.sum();
//        System.out.println("Soma dos elementos da árvore: " + sum);
//
//    }
//}
