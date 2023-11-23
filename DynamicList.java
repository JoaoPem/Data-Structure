package Estrutura_Dados.Listas;
public class DynamicList {
    private No primeiro;
    private No ultimo;

    private static class  No{
        int valor;
        No proximo;
        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
    public DynamicList(){
        primeiro = null;
        ultimo = null;
    }
    public void adicionarFinal(int valor) {
        No novo = new No(valor);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }
    public void removerFinal() {
        if (ultimo != null) {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;
            } else {
                No atual = primeiro;
                while (atual.proximo != ultimo) {
                    atual = atual.proximo;
                }
                ultimo = atual;
                ultimo.proximo = null;
            }
        }
    }
    public void adicionarInicio(int valor){
        No novo = new No(valor);
        if (primeiro == null){
            primeiro = novo;
            ultimo = novo;
        }
        novo.proximo = primeiro;
        primeiro = novo;
    }
    public void removeInicio(){
        if (primeiro != null){
            if (primeiro == ultimo){
                primeiro = null;
                ultimo = null;
            }
            No aux = primeiro;
            primeiro = primeiro.proximo;
            aux.proximo = null;
        }
    }
    public void exibir() {
        No atual = primeiro;

        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }

        System.out.println();
    }
        /*
    public void adicionarPosicao(int valor, int pos) {

    }

    public void removerPosicao(int pos) {

    }

    public int buscar(int valor) {

    }

    public boolean vazia() {

    }

    public int getTamanho() {

    }
    */
}
