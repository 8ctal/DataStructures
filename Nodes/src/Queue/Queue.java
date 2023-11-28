package Queue;

public class Queue {
    private Node_4 head;
    private Node_4 tail;
    private int size;

    public Queue() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    public void print() {
        Node_4 current = head;
        while (current != null) {
            System.out.print(current.data + " <- ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        System.out.println("Dequeued " + data + " from the queue.");
        return data;
    }

    public void enqueue(int data) {
        Node_4 newNode = new Node_4(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Enqueued " + data + " into the queue.");
        size++;
    }

    public void reverse() {
        Node_4 current = head;
        Node_4 prev = null;
        Node_4 next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

}
