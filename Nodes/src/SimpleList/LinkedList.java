package SimpleList;

public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node runNode = head;
        while (runNode != null) {
            System.out.print(runNode.data + " -> ");
            runNode = runNode.next;
        }
        System.out.println("NULL");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertBeginning(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        size++;
    }

    public void insertEnd(int data) {
        Node new_node = new Node(data);
        Node runNode = head;
        while (runNode.next != null) {
            runNode = runNode.next;
        }
        runNode.next = new_node;
        size++;

    }

    public void insertByPos(int data, int pos) {
        Node runNode = head;
        Node new_node = new Node(data);
        while (size - pos < size && runNode.next != null) {
            runNode = runNode.next;
            pos--;
        }
        if (pos <= size) {
            new_node.next = runNode.next;
            runNode.next = new_node;
            size++;
        } else {
            System.out.println("No se puede agregar");
        }

    }

    public void deleteFirstItem() {
        if (!isEmpty()) {
            Node init = head;
            head = init.next;
            init.next = null;
            size--;
        }
    }

    public void deleteLastItem() {
        if (isEmpty() || head.next == null) {
            head = null;
        } else {
            Node runNode = head;
            while (runNode.next.next != null) {
                runNode = runNode.next;
            }
            runNode.next = null;
        }
        size--;
    }

    public void deleteItemByPos(int pos) {
        Node runNode = head;
        while (size - (pos - 1) < size && runNode.next.next != null) {
            runNode = runNode.next;
            pos--;
        }
        runNode.next = runNode.next.next;
        size--;
    }

    public void deleteByData(int data) {
        Node runNode = head;
        while (runNode.next != null) {
            if (runNode.next.data == data) {
                runNode.next = runNode.next.next;
                size--;
            }
            runNode = runNode.next;
        }
    }

    ////////CAMBIOS////////
    public int searchByIndex(int index) {
        Node runNode = head;
        while ((size - index) < size && runNode != null) {
            runNode = runNode.next;
            index--;
        }
        return runNode.data;
    }

    /*public int searchByData(int data) {
        Node runNode = head;
        int i = 0;
        while (runNode != null) {
            if (runNode.data == data) {
                return i;
            }
            runNode = runNode.next;
            i++;
        }
        return -1;
    }*/

    public void searchByDataFixed(int data) {

        Node runNode = head;
        int i = 0;
        while (runNode != null) {
            if (runNode.data == data) {
                System.out.println("El dato " + runNode.data + " se encuentra en la posicion: " + i);
            }
            runNode = runNode.next;
            i++;
        }
    }

    public void searchByIndexFixed(int index) {
        Node runNode = head;
        while ((size - index) < size && runNode != null) {
            runNode = runNode.next;
            index--;
        }
        System.out.println("El dato en la posicion " + index + " es: " + runNode.data);
    }

    public void deleteList() {
        head = null;
        size = 0;

    }

    public void moveLastToHead() {
        if (head == null || head.next == null) {
            return;
        }
        Node runNode = null;
        Node lastNode = head;
        while (lastNode.next != null) {
            runNode = lastNode;
            lastNode = lastNode.next;
        }
        runNode.next = null;
        lastNode.next = head;
        head = lastNode;
        //using the functions we already have
        /*insertBeginning(searchByIndex(size-1));
        deleteLastItem();*/
    }

    public void deleteDuplicates() {
        Node runNode = head;
        while (runNode != null) {
            Node runNode2 = runNode;
            while (runNode2.next != null) {
                if (runNode2.next.data == runNode.data) {
                    runNode2.next = runNode2.next.next;
                    size--;
                } else {
                    runNode2 = runNode2.next;
                }
            }
            runNode = runNode.next;
        }
    }
}
