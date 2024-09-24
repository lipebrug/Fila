public class Fila<T> {

    private int top = -1;   
    private int base = 0;   
    private T[] data;       

    @SuppressWarnings("unchecked")
    public Fila(int size) {
        data = (T[]) new Object[size];
    }

    public void add(T value) {
        if (isFull()) {
            System.out.println("Fila cheia. Não é possível adicionar.");
            return;
        }
        top = move(top);  
        data[top] = value; 
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("Fila vazia. Não há elementos para remover.");
            return null;
        }
        T value = data[base];  
        base = move(base);    
        return value;
    }

    public void clear() {
        top = -1;
        base = 0;
        System.out.println("Fila foi esvaziada.");
    }

    public boolean isFull() {
        return move(top) == base && top != -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private int move(int position) {
        return (position + 1) % data.length;
    }
}
