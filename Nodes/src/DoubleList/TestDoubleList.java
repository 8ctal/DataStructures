package DoubleList;

public class TestDoubleList {

    public static void main(String[] Args) {
        DbleLinkedList test = new DbleLinkedList();
        test.printList();
        test.printReverseList();

        System.out.println("Insertando al inicio...");
        test.insertBeginning(5);
        test.insertBeginning(4);
        test.insertBeginning(3);
        test.insertBeginning(2);
        test.printList();
        test.printReverseList();

        System.out.println("Insertando al final...");
        test.insertEnd(6);
        test.printList();
        test.printReverseList();
        System.out.println("El tamaño de la lista es: " + test.getSize());

        System.out.println("Insertando por posicion...");
        test.insertByPosition(7, 1);
        test.printList();
        test.printReverseList();

        System.out.println("Eliminando al inicio...");
        test.deleteFirstItem();
        test.printList();
        test.printReverseList();
        System.out.println("El tamaño de la lista es: " + test.getSize());

        System.out.println("Eliminando al final...");
        test.deleteLastItem();
        test.printList();
        test.printReverseList();

        System.out.println("Eliminando por posicion...");
        test.deleteByPos(2);
        test.printList();
        test.printReverseList();
        System.out.println("El tamaño de la lista es: " + test.getSize());

        System.out.println("Eliminando por valor...");
        test.deleteByValue(7);
        test.printList();
        test.printReverseList();

        ///FIXED VALUE DELETION///
        test.insertEnd(5);
        test.deleteByValueAll(5);
        test.printList();
        test.printReverseList();

        //FILL LIST///
        test.insertBeginning(1);
        test.insertBeginning(2);
        test.insertBeginning(3);

        System.out.println("Buscando por índice...");
        test.searchByIndex(4);
        test.printList();
        test.printReverseList();

        System.out.println("Buscando por valor...");
        test.searchByValue(3);


    }
}
