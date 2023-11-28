package Stack;

public class Stack {
    private Node_3 top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int peek() {
        if (this.top == null) {
            return -1;
        }
        return this.top.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    public void push(int data) {
        Node_3 node = new Node_3(data);
        node.next = this.top;
        this.top = node;
        this.size++;
        System.out.println("Pushed " + data + " onto the stack.");
    }

    public int pop() {
        if (this.top == null) {
            return -1;
        }
        int data = this.top.data;
        this.top = this.top.next;
        this.size--;
        System.out.println("Popped " + data + " off the stack.");
        return data;
    }

    public void printStack() {
        Node_3 current = this.top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
