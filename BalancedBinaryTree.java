package Estrutura_Dados.Arvore;

class Node {
    int key;
    int height;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.height = 1;
        this.left = this.right = null;
    }
}

class AVLTree {
    Node root;

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int updateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    Node rotateLeft(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = updateHeight(z);
        y.height = updateHeight(y);

        return y;
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = updateHeight(y);
        x.height = updateHeight(x);

        return x;
    }

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            // Duplicatas não são permitidas em uma árvore de busca binária
            return root;
        }

        root.height = updateHeight(root);

        int balance = balanceFactor(root);

        // Casos de desequilíbrio
        // Esquerda-Esquerda
        if (balance > 1 && key < root.left.key) {
            return rotateRight(root);
        }
        // Direita-Direita
        if (balance < -1 && key > root.right.key) {
            return rotateLeft(root);
        }
        // Esquerda-Direita
        if (balance > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        // Direita-Esquerda
        if (balance < -1 && key < root.right.key) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    void insertKey(int key) {
        root = insert(root, key);
    }

    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int balance = balanceFactor(root);

        return Math.abs(balance) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    Node balanceTree(Node root) {
        if (root == null) {
            return null;
        }

        root.left = balanceTree(root.left);
        root.right = balanceTree(root.right);

        int balance = balanceFactor(root);

        if (balance > 1) {
            if (balanceFactor(root.left) >= 0) {
                return rotateRight(root);
            } else {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }

        if (balance < -1) {
            if (balanceFactor(root.right) <= 0) {
                return rotateLeft(root);
            } else {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    void balance() {
        root = balanceTree(root);
    }

    void display(Node root, int level, String prefix) {
        if (root != null) {
            System.out.println("Level " + level + " " + prefix + root.key);
            display(root.left, level + 1, "L ");
            display(root.right, level + 1, "R ");
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Receber números inteiros como entrada de dados
        int[] numbers = {6, 2, 8, 1, 4, 7, 9, 3, 5};

        // Armazenar os números em uma árvore binária
        for (int number : numbers) {
            avlTree.insertKey(number);
        }

        // Verificar se a árvore está balanceada
        if (avlTree.isBalanced(avlTree.root)) {
            System.out.println("A árvore está balanceada.");
        } else {
            System.out.println("A árvore não está balanceada.");

            // Fazer o balanceamento da árvore
            avlTree.balance();
            System.out.println("Árvore balanceada:");
        }

        // Exibir a árvore balanceada
        avlTree.display(avlTree.root, 0, "Root: ");
    }
}