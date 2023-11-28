package DoubleList;

public class DbleLinkedList {
    private Node_2 head, tail;
    private int size;

    public DbleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node_2 runNode = head;
        while (runNode != null) {
            System.out.print(runNode.data + " <-> ");
            runNode = runNode.next;
        }
        System.out.println("NULL");
    }

    public void printReverseList() {
        Node_2 runNode = tail;
        while (runNode != null) {
            System.out.print(runNode.data + " <-> ");
            runNode = runNode.prev;
        }
        System.out.println("INICIO");
    }

    public void insertBeginning(int data) {
        Node_2 new_node = new Node_2(data);
        if (!isEmpty()) {
            new_node.next = head;
            head.prev = new_node;
        } else {
            tail = new_node;
        }
        head = new_node;
        size++;
    }

    public void insertEnd(int data) {
        Node_2 new_node = new Node_2(data);
        if (!isEmpty()) {
            tail.next = new_node;
            new_node.prev = tail;
        } else {
            head = new_node;
        }
        tail = new_node;
        size++;
    }

    public void insertByPosition(int data, int pos) {
        Node_2 runNode = head;
        Node_2 new_node = new Node_2(data);
        while (size - pos < size - 1 && runNode.next != null) {
            runNode = runNode.next;
            pos--;
        }
        if (pos < size - 1) {
            new_node.next = runNode.next;
            runNode.next = new_node;
            new_node.prev = runNode;
            new_node.next.prev = new_node;
            size++;
        } else {
            System.out.println("No se puede agregar");
        }

    }

    public void deleteByPos(int pos) {
        Node_2 runNode = head;
        while (size - pos < size && runNode.next != null) {
            runNode = runNode.next;
            pos--;
        }
        if (pos <= size) {
            runNode.prev.next = runNode.next;
            runNode.next.prev = runNode.prev;
            runNode.next = null;
            runNode.prev = null;
            size--;
        } else {
            System.out.println("No se puede eliminar");
        }
    }

    public void deleteFirstItem() {
        if (!isEmpty()) {
            Node_2 init = head;
            head = init.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            init.next = null;
            size--;
        } else {
            System.out.println("No hay elementos para eliminar");
        }
    }

    public void deleteLastItem() {
        if (!isEmpty()) {
            Node_2 last = tail;
            tail = last.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            last.prev = null;
            size--;
        } else {
            System.out.println("No hay elementos para eliminar");
        }
    }

    public void deleteByValue(int data) {
        Node_2 runNode = head;
        while (runNode != null && runNode.data != data) {
            runNode = runNode.next;
        }
        if (runNode != null) {
            if (runNode == head) {
                deleteFirstItem();
            } else if (runNode == tail) {
                deleteLastItem();
            } else {
                runNode.prev.next = runNode.next;
                runNode.next.prev = runNode.prev;
                runNode.next = null;
                runNode.prev = null;
                size--;
            }
        } else {
            System.out.println("No se encontro el valor");
        }
    }

    public void deleteByValueAll(int data) {
        Node_2 runNode = head;
        while (runNode != null) {
            if (runNode.data == data) {
                if (runNode == head) {
                    deleteFirstItem();
                    runNode = head;
                } else if (runNode == tail) {
                    deleteLastItem();
                    runNode = tail;
                } else {
                    runNode.prev.next = runNode.next;
                    runNode.next.prev = runNode.prev;
                    runNode.next = null;
                    runNode.prev = null;
                    size--;
                    runNode = runNode.prev;
                }
            } else {
                runNode = runNode.next;
            }
        }
    }

    public void searchByIndex(int pos) {
        Node_2 runNode = head;
        int index = 0;
        while (runNode != null) {
            if (index == pos) {
                System.out.println("El valor en el indice " + index + " es: " + runNode.data);
                break;
            }
            runNode = runNode.next;
            index++;
        }
    }

    public void searchByValue(int data) {
        Node_2 runNode = head;
        int index = 0;
        while (runNode != null) {
            if (runNode.data == data) {
                System.out.println("El valor " + data + " se encuentra en el indice " + index);
            }
            runNode = runNode.next;
            index++;
        }
    }

    public void deleteAll() {
        while (isEmpty()) {
            deleteFirstItem();
        }
    }

}
