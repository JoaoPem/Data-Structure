package Estrutura_Dados.Filas;

public class DynamicQueue {
    private Nodo frente;
    private Nodo fim;
    private int tamanho;

    // Classe interna para representar os elementos da fila
    private static class Nodo {
        int valor;
        Nodo proximo;
        public Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
    public DynamicQueue() {
        frente = null;
        fim = null;
        tamanho = 0;
    }
    public void enqueue(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (isEmpty()){
            frente = novoNodo;
            fim = novoNodo;
        }
        fim.proximo = novoNodo;
        fim = novoNodo;
        tamanho++;
    }
    public int dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Fila está vazia");
        }
        int valorRemovido = frente.valor;
        frente = frente.proximo;
        tamanho--;
            if (isEmpty()){
                fim = null;
            }
        return valorRemovido;
    }
    public boolean isEmpty() {
      return tamanho == 0;
    }
    public int size() {
        return tamanho;
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return frente.valor;
    }
    public void clear() {
        frente = null;
        fim = null;
        tamanho = 0;
    }
    public int[] toArray() {
        int[] elementos = new int[tamanho];
        Nodo atual = frente;
        int indice = 0;
        while (atual != null) {
            elementos[indice] = atual.valor;
            atual = atual.proximo;
            indice++;
        }
        return elementos;
    }
    public static class Main {
        public static void main(String[] args) {
            DynamicQueue fila = new DynamicQueue();
            fila.enqueue(1);
            fila.enqueue(2);
            fila.enqueue(3);
            System.out.println("Tamanho da fila: " + fila.size()); // Deve imprimir "3"
            System.out.println("Elemento da frente da fila: " + fila.peek()); // Deve imprimir "1"
            fila.dequeue();
            fila.enqueue(4);
            System.out.println("Elemento da frente da fila: " + fila.peek()); // Deve imprimir "2"
            int[] elementos = fila.toArray();
            System.out.print("Elementos da fila: ");
            for (int elemento : elementos) {
                System.out.print(elemento + " ");
            }
            System.out.println(); // Deve imprimir "2 3 4"
        }

    }
}

