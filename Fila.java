public class Fila<T> {

    private int top = -1;   // Índice do elemento do topo
    private int base = 0;   // Índice do elemento da base
    private T[] data;       // Array para armazenar os elementos

    // Construtor para inicializar o array com o tamanho da fila
    @SuppressWarnings("unchecked")
    public Fila(int size) {
        data = (T[]) new Object[size];
    }

    // Método para adicionar um elemento à fila
    public void add(T value) {
        if (isFull()) {
            System.out.println("Fila cheia. Não é possível adicionar.");
            return;
        }
        top = move(top);   // Mover o ponteiro do topo para o próximo índice disponível
        data[top] = value; // Inserir o valor
    }

    // Método para remover um elemento da fila
    public T remove() {
        if (isEmpty()) {
            System.out.println("Fila vazia. Não há elementos para remover.");
            return null;
        }
        T value = data[base];  // Recuperar o elemento da base
        base = move(base);     // Mover o ponteiro da base para o próximo índice
        return value;
    }

    // Método para limpar a fila
    public void clear() {
        top = -1;
        base = 0;
        System.out.println("Fila foi esvaziada.");
    }

    // Método para verificar se a fila está cheia
    public boolean isFull() {
        return move(top) == base && top != -1;
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return top == -1;
    }

    // Método auxiliar para calcular o próximo índice circular
    private int move(int position) {
        return (position + 1) % data.length;
    }

    // Main para testar a implementação
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>(5); // Fila de tamanho 5

        // Teste de inserção de elementos
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50); // A fila agora está cheia
        fila.add(60); // Não pode adicionar, pois está cheia

        // Teste de remoção de elementos
        System.out.println("Removido: " + fila.remove());
        System.out.println("Removido: " + fila.remove());

        // Teste de inserção após remoção
        fila.add(60);
        fila.add(70);

        // Teste de remoção
        System.out.println("Removido: " + fila.remove());
        System.out.println("Removido: " + fila.remove());

        // Teste de limpar a fila
        fila.clear();
    }
}
