package Estrutura_Dados.Pilhas;

public class DynamicStack <T> {
    private class Node {
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node top;
    private int size;
    public DynamicStack() {
        top = null;
        size = 0;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int size() {
        return size;
    }
    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return top.data;
    }
    public static void main(String[] args) {
        DynamicStack<Integer> stack = new DynamicStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
    }
}
