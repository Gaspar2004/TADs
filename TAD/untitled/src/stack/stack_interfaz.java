package stack;

public interface stack_interfaz <T> {
    void push(T value);
    T pop() throws EmptyStackException;
    T peek();
    int size();
}

