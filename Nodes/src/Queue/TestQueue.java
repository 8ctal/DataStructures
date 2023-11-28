package Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.print();
        q.dequeue();
        q.dequeue();
        q.print();
        System.out.println("Peek: " + q.peek());
        System.out.println("Size: " + q.getSize());
        System.out.println("Is empty: " + q.isEmpty());
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        q.reverse();
        q.print();
        q.clear();

    }
}
