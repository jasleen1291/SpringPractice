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
public class RBNode {

    private Color color;
    final RedBlackTree tree;

    public boolean isRed() {
        return color == Color.RED;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    void setRed() {
        color = Color.RED;
    }

    void setBlack() {
        color = Color.BLACK;
    }
    private RBNode left, right, parent;
    private int key;

    public RBNode(RedBlackTree tree) {
        color = Color.BLACK;
        this.tree = tree;
        this.key = Integer.MAX_VALUE;
    }

    public RBNode(RedBlackTree tree, int key) {
        this.tree = tree;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public RBNode left() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode right() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode parent() {
        return parent;
    }

    public RBNode grandParent() {
        if (this == tree.nullNode && parent() == tree.nullNode) {
            return tree.nullNode;
        }
        return parent().parent();
    }

    public RBNode uncle() {

        if (grandParent() == tree.nullNode) {
            return tree.nullNode;
        } else if (parent().isLeft()) {

            return grandParent().right();
        } else if (parent().isRight()) {
            return grandParent().left();
        }
        return tree.nullNode;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" + key + "}";
    }

    public boolean isLeft() {
        if (parent() != tree.nullNode) {
            return this == parent().left();
        }
        return false;
    }

    public boolean isRight() {
        if (parent() != tree.nullNode) {
            return this == parent().right();
        }
        return false;
    }

    public Color getColor() {
        return color;
        //To change body of generated methods, choose Tools | Templates.
    }

    public RBNode sibling() {
        if (isLeft()) {
            return parent().right();
        } else {
            return parent().left();
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
