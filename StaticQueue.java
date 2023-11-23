package Estrutura_Dados.Filas;

public class StaticQueue {
    private final int[] elementos;
    private int tamanho;
    private final int capacidade;
    private int frente;
    private int fim;
    public StaticQueue(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    public void enfileirar(int elemento) {
        if(tamanho > capacidade){
            throw new RuntimeException("Fila Cheia");
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }
    public int desenfileirar() {
        if (!estaVazia()){
            int elementoRemovido = elementos[0];
            for (int i = 0; i < tamanho - 1; i++){
                elementos[i] = elementos[i+1];
            }
            tamanho--;
            return elementoRemovido;
        }
        throw new IllegalStateException("Fila vazia");
    }
    public boolean estaVazia() {
        return tamanho == 0;
    }
    public int tamanho() {
        return tamanho;
    }

    public int peek(){
        return elementos[tamanho-1];
    }
    public static void main(String[] args) {
        StaticQueue fila = new StaticQueue(5);
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        System.out.println(fila.peek());
        System.out.println("Elemento removido: " + fila.desenfileirar());
        System.out.println("Tamanho da fila: " + fila.tamanho());
        while (!fila.estaVazia()) {
            System.out.println("Elemento removido: " + fila.desenfileirar());
        }
    }
}
