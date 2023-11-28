package Trees;

import java.util.*;

public class BinaryTree {
    public Node_5 root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node_5(data);
        } else {
            Node_5 current = root;
            Node_5 parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node_5(data);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node_5(data);
                        return;
                    }
                }
            }
        }
    }

    public void insert(Node_5 root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                System.out.println(" Inserted " + data + " to left of " + root.data);
                root.left = new Node_5(data);
            }
        } else if (data > root.data) {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                System.out.println(" Inserted " + data + " to right of " + root.data);
                root.right = new Node_5(data);
            }
        }

    }

    public Node_5 insertRec(Node_5 root, int data) {
        if (root == null) {
            root = new Node_5(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void traverseInOrder(Node_5 root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.print(root.data + " ");
            traverseInOrder(root.right);
        }
    }

    public void traverseInWidth() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node_5> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node_5 node = nodes.remove();
            System.out.print(" " + node.data);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

    }

    public void traversePreOrder(Node_5 root) {
        if (root != null) {
            System.out.print(" " + root.data);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    public void traversePostOrder(Node_5 root) {
        if (root != null) {
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.print(" " + root.data);
        }
    }

    public Node_5 searchRec(Node_5 root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data > data) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    public Node_5 search(int data) {

        Node_5 current = root;
        while (current != null) {
            if (current.data == data) {
                return current;
            } else if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public Node_5 deleteNodeRec(Node_5 root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteNodeRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNodeRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node_5 minNode = minValue(root.right);
            root.data = minNode.data;
            root.right = deleteNodeRec(root.right, minNode.data);
        }
        return root;
    }

    public void deleteNode(int data) {
        deleteNodeRec(root, data);
    }

    public Node_5 minValue(Node_5 root) {
        if (root.left == null) return root;
        else
            return minValue(root.left);
    }

    public void reflect(Node_5 root) {
        if (root != null) {
            Node_5 temp = root.left;
            root.left = root.right;
            root.right = temp;
            reflect(root.left);
            reflect(root.right);
        }
    }
}
