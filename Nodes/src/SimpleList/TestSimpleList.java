package SimpleList;

public class TestSimpleList {

    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        test.printList();

        System.out.println("Insertar al inicio");
        test.insertBeginning(5);
        test.printList();

        System.out.println("Insertar al final");
        test.insertEnd(6);
        test.printList();

        System.out.println("Insertar al inicio");
        test.insertBeginning(4);
        test.printList();

        test.insertEnd(7);
        test.insertEnd(9);
        test.printList();

        System.out.println("Insertando por index");
        test.insertByPos(8, 3);
        test.printList();
        test.insertByPos(3, 0);
        test.printList();
        test.insertByPos(10, 6);
        test.printList();
        System.out.println("El tamano de la lista es: " + test.getSize());

        test.deleteFirstItem();
        test.printList();
        System.out.println("El tamano de la lista es: " + test.getSize());

        test.deleteLastItem();
        test.printList();
        System.out.println("El tamano de la lista es: " + test.getSize());

        test.deleteItemByPos(4);
        test.printList();
        System.out.println("El tamano de la lista es: " + test.getSize());

        //BUSCANDO DATO E INDEX
        System.out.println("Buscando por index...");
        test.searchByIndexFixed(2);
        test.insertByPos(7, 3);
        System.out.println("Buscando por dato...");
        test.searchByDataFixed(7);
        System.out.println("El tamano de la lista es: " + test.getSize());
        test.printList();
        test.deleteByData(7); //Need a fix
        System.out.println("Initial list...");
        test.printList();

        //MOVE LAST TO HEAD
        System.out.println("Moving last to head...");
        test.moveLastToHead();
        test.printList();
        test.moveLastToHead();
        test.printList();
        test.moveLastToHead();
        test.printList();

        //DELETING DUPLICATES
        System.out.println("Deleting duplicates...");
        test.insertEnd(5);
        test.insertEnd(5);
        test.insertEnd(5);
        test.insertBeginning(7);
        test.deleteDuplicates();
        test.printList();
    }

}
