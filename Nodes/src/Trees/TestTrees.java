package Trees;

import java.util.*;

public class TestTrees {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        ///Node_5 root = new Node_5(5);
        Node_5 root = tree.insertRec(null, 12);
        tree.root = root;
        System.out.println("Building tree with root value " + root.data);
        tree.insert(root, 6);
        tree.insert(root, 16);
        tree.insert(root, 3);
        tree.insert(root, 8);
        tree.insert(root, 13);
        tree.insert(root, 18);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 7);
        tree.insert(root, 10);
        tree.insert(root, 15);
        tree.insert(root, 17);
        tree.insert(root, 20);
        tree.insert(root, 1);
        tree.insert(root, 5);
        tree.insert(root, 9);
        tree.insert(root, 11);
        tree.insert(root, 14);
        tree.insert(root, 19);

        System.out.println("Deleting by data...");
        tree.deleteNodeRec(root, 3);
        tree.deleteNodeRec(root, 8);
        tree.deleteNodeRec(root, 16);
        tree.deleteNodeRec(root, 12);
        System.out.println("Inorder traversal of binary tree is:");
        tree.traverseInOrder(root);

        System.out.println("\nPreorder traversal of binary tree is:");
        tree.traversePreOrder(root);

        System.out.println("\nPostorder traversal of binary tree is:");
        tree.traversePostOrder(root);

        System.out.println("\nWidth traversal of binary tree is:");
        tree.traverseInWidth();

        System.out.println("\nSearching by data...");
        System.out.println(tree.searchRec(root, 30));
        System.out.println(tree.search(65));
        System.out.println(tree.search(75));
        System.out.println(tree.search(100));

        System.out.println("Deleting by data...");
        tree.deleteNodeRec(root, 85);
        tree.traverseInOrder(root);

        System.out.println("\nReflecting tree...");
        tree.reflect(root);
        tree.traverseInWidth();
        /*System.out.println("Original String: Data Structures and Algorithms");
        System.out.println(reverseCharsAtWordsUsingStacks("Data Structures and Algorithms"));*/
    }
    /*public static String reverseCharsAtWordsUsingStacks(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            Stack<Character> stack = new Stack<>();
            for (char c : word.toCharArray()) {
                stack.push(c);
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append(" ");
        }
        return sb.toString();
    }*/

}


