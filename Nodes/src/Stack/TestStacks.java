package Stack;

public class TestStacks {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);  
        stack.push(4);
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.push(5);
        stack.printStack();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.getSize());
        System.out.println("Is empty: " + stack.isEmpty());
        stack.clear();
        stack.printStack();
        System.out.println("Size: " + stack.getSize());
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Peek: " + stack.peek());

    }

}
