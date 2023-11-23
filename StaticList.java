package Estrutura_Dados.Listas;

public class StaticList {
    private int[] vetor_elemetos;
    private int numero_elementos;

    public StaticList(int capacidade){
        this.vetor_elemetos = new int[capacidade];
        this.numero_elementos = 0;
    }
    public boolean vazio(){
        if(numero_elementos == 0){
            return true;
        }
        return false;
    }
     public void adiciona_final(int elemento){
        if (numero_elementos < vetor_elemetos.length){
            vetor_elemetos[numero_elementos] = elemento;
            numero_elementos ++;
        }
         throw new RuntimeException("Estrutura cheia");
     }
     public void remove_final(){
        if (vazio()){
            throw new RuntimeException("Estrutura vazia");
        }
        numero_elementos--;
     }
     public void adiciona_posicao(int valor, int posicao){
        if (posicao < vetor_elemetos.length){
            for (int i = numero_elementos; i > posicao; i--){
                vetor_elemetos[i] = vetor_elemetos[i-1];
            }
            vetor_elemetos[posicao] = valor;
            numero_elementos++;
        }
         System.out.println("Posicao informada nao existe.");
     }
     public void remove_posicao(int posicao){
        if (vazio()){
            throw new RuntimeException("Lista Vazia!");
        } else if (posicao < 0 || posicao >= numero_elementos) {
            throw new RuntimeException("Posição Inválida");
        }
        for (int i = posicao; i < numero_elementos - 1; i++){
            vetor_elemetos[i] = vetor_elemetos[i+1];
            numero_elementos--;
        }
     }
    public void adiciona_inicio(int valor, int i) {
        adiciona_inicio(valor, 0);
    }
    public void remove_inicio() {
        remove_posicao(0);
    }
    public int buscar(int valor){
        for (int i = 0; i <numero_elementos; i++){
            if (valor == vetor_elemetos[i]){
                return i;
            }
        }
        return -1;
    }
    public boolean exibir(){
        for (int i = 0; i < numero_elementos; i ++){
            System.out.print(vetor_elemetos[i] + " ");
        }
        System.out.println();
        return false;
    }
    public int getTamanho() {
        return numero_elementos;
    }
    public static void main(String[] args){
        StaticList lista = new StaticList(5);
        lista.adiciona_posicao(30,0);
        System.out.println(lista.exibir());
    }
}
