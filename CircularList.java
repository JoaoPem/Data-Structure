package Estrutura_Dados.Listas;

public class CircularList {
    private Node cabeca;
    private Node cauda;
    public CircularList(){
        cabeca = null;
        cauda = null;
    }
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public void adiciona(int valor){
        Node novoNo = new Node(valor);
        if (cabeca == null){
            cabeca = novoNo;
            cauda = novoNo;
        }else {
            cauda.next = novoNo;
            cauda = novoNo;
        }
        cauda.next = cabeca;
    }
    public void display() {
        if (cabeca == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node current = cabeca;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != cabeca);
        System.out.println();
    }
    public static void main(String[] args){
        CircularList lista = new CircularList();
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        System.out.println("Lista Circular:");
        lista.display();
    }

}
