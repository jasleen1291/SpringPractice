/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author jasleen
 */
public class BST {

    private Node root;

    Node getRoot() {
        return root;
    }

    void setRoot(Node root) {
        this.root = root;
    }

    void insert(Node z) {
        Node y = null;
        Node x = getRoot();
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.left();
            } else {
                x = x.right();
            }
        }
        z.setParent(y);
        if (y == null) {
            setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }

    }

    void inorder(Node x) {

        if (x != null) {
            inorder(x.left());
            System.out.print(x.getKey() + "\t");
            inorder(x.right());
        }

    }

    void leftRotate(Node x) {
        Node y = x.right();
        if(y==null)
        {
            System.out.println("The tree cannot be left rotated");
            return;
        }
        x.setRight(y.left());//Turn y's left subtree into x's subtree
        if (y.left() != null) {
            y.left().setParent(x);

        }
        y.setParent(x.parent());
        if (x.parent() == null) {
            setRoot(y);
        } else if (x == x.parent().left()) {
            x.parent().setLeft(y);
        } else {
            x.parent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);

    }

    void rightRotate(Node x) {
        Node y = x.left();
        if(y==null)
        {
            System.out.println("The tree cannot be right rotated");
            return;
        }
        x.setLeft(y.right());//Turn y's left subtree into x's subtree
        if (y.right() != null) {
            y.right().setParent(x);

        }
        y.setParent(x.parent());
        if (x.parent() == null) {
            setRoot(y);
        } else if (x == x.parent().left()) {
            x.parent().setLeft(y);
        } else {
            x.parent().setRight(y);
        }
        y.setRight(x);
        x.setParent(y);

    }
    void iterativeInorder(Node x, int k) {

        if (x != null) {
            inorder(x.left());
            System.out.print(x.getKey());
            if (x.getKey() > k) {
                System.out.print(x.getKey() + "\t");
                return;
            }
            inorder(x.right());
        }

    }

    Node successor(Node x) {
        if (x.right() != null) {
            x = x.right();
            while (x.left() != null) {
                x = x.left();
            }
            return x;
        } else {
            Node y = x.parent();
            while (y != null && x == y.right()) {
                x = y;
                y = y.parent();
            }
            return y;
        }
    }

    Node predecessor(Node x) {
        Node predc = null;
        if (x.left() != null) {
            predc = x.left();
            // System.out.println("Checking-"+predc.getKey());
            while (predc.right() != null) {

                predc = predc.right();

            }

            return predc;
        } else {
            predc = x.parent();
            while (predc != null && x == predc.left()) {
                x = predc;
                predc = predc.parent();
            }

        }
        return predc;

    }

    void transplant(Node u, Node v) {
        if (u.parent() == null) {
            setRoot(v);
        } else if (u == u.parent().left()) {
            u.parent().setLeft(v);
        } else {
            u.parent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.parent());
        }
    }

    void delete(Node x) {
        if (x.left() == null) {
            transplant(x, x.right());
        } else if (x.right() == null) {
            transplant(x, x.left());
        } else {
            Node y = minChild(x.right());
            if (y.parent() != x) {
                transplant(y, y.right());
                y.setRight(x.right());
                y.right().setParent(y);
            }
            transplant(x, y);
            y.setLeft(x.left());
            y.left().setParent(y);
        }
    }

    public static void main(String[] args) {
        
        BST tree = new BST();
        Node node45 = new Node(45);
        tree.insert(node45);
        Node node30 = new Node(30);
        tree.insert(node30);
        Node node56 = new Node(56);
        tree.insert(node56);
        Node node14 = new Node(14);
        tree.insert(node14);
        Node node40 = new Node(40);
        tree.insert(node40);
        Node node47 = new Node(47);
        tree.insert(node47);
        Node node58 = new Node(58);
        tree.insert(node58);
        Node node10 = new Node(10);
        tree.insert(node10);
        Node node18 = new Node(18);
        tree.insert(node18);
        Node node44 = new Node(44);
        tree.insert(node44);
        Node node91 = new Node(91);
        tree.insert(node91);
        Node node4 = new Node(4);
        tree.insert(node4);
        Node node25 = new Node(25);
        tree.insert(node25);
        Node node42 = new Node(42);
        tree.insert(node42);
        Node node76 = new Node(76);
        tree.insert(node76);
        Node node92 = new Node(92);
        tree.insert(node92);
        tree.inorder(tree.getRoot());
        System.out.print(node56.right()+"\t");
        System.out.print(node91.left()+"\t");
        System.out.print(node91.right()+"\t");
        System.out.print(node58.left()+"\t");
        System.out.print(node58.right()+"\t");
        System.out.print(node92.left()+"\t");
        System.out.print(node92.right()+"\t");
        System.out.print(node76.left()+"\t");
        System.out.print(node76.right()+"\t");
        System.out.println("\tAfter left rotate");
        tree.leftRotate(node58);
        System.out.print(node56.right()+"\t");
        System.out.print(node91.left()+"\t");
        System.out.print(node91.right()+"\t");
        System.out.print(node58.left()+"\t");
        System.out.print(node58.right()+"\t");
        System.out.print(node92.left()+"\t");
        System.out.print(node92.right()+"\t");
        System.out.print(node76.left()+"\t");
        System.out.print(node76.right()+"\t");
        System.out.println("After Right rotate");
        tree.rightRotate(node91);
        System.out.print(node56.right()+"\t");
        System.out.print(node91.left()+"\t");
        System.out.print(node91.right()+"\t");
        System.out.print(node58.left()+"\t");
        System.out.print(node58.right()+"\t");
        System.out.print(node92.left()+"\t");
        System.out.print(node92.right()+"\t");
        System.out.print(node76.left()+"\t");
        System.out.print(node76.right()+"\t");
    }

    Node minChild(Node x) {
        while (x.left() != null) {
            x = x.left();
        }
        return x;
    }

}

class Node {

    private Node left, right, parent;
    private int key;

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node left() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node right() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node parent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +key+ "}";
    }

}
