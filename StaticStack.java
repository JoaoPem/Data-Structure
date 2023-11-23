package Estrutura_Dados.Pilhas;

public class StaticStack <T>{
    private Object[] array;
    private int top;
    private int maxSize;
    public StaticStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.array = new Object[capacity];
        this.top = -1;
        this.maxSize = capacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == maxSize - 1;
    }
    public int size(){
        return maxSize +1;
    }

    //OLHAR ELEMENTO
    @SuppressWarnings("unchecked")
    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("A pilha ta Vazia");
        }
        T data = (T) array[top];
        return data;
    }

    //ADICIONAR ELEMENTO
    public void push(T data) {
        if (isFull()){
            throw new IllegalStateException("A pilha ta Vazia");
        }
        top++;
        array[top] = data;
    }

    //RETIRAR ELEMENTO
    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()){
            throw new IllegalStateException("A pilha ta Vazia");
       }
        T dado = (T) array[top];
       top--;
       return dado;
    }

    public static void main(String[] args) {
        StaticStack<Integer> stack = new StaticStack<>(5);
        System.out.println(stack.array.length);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.maxSize);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
    }
}