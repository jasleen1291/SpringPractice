/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jasleen
 */
public class RedBlackTreeTest {
    
    public RedBlackTreeTest() {
    }

    @Test
    public void test1() {
        RedBlackTree tree=new RedBlackTree();
        RBNode rbNode16 = new RBNode(tree,16);
        tree.insert(rbNode16 );
        RBNode rbNode14 = new RBNode(tree,14);
        tree.insert(rbNode14 );
        RBNode rbNode55 = new RBNode(tree,55);
        tree.insert(rbNode55);
        RBNode rbNode10 = new RBNode(tree,10);
        tree.insert(rbNode10);
        RBNode rbNode15 = new RBNode(tree,15);
        tree.insert(rbNode15 );
        RBNode rbNode12 = new RBNode(tree,12);
        tree.insert(rbNode12 );
        RBNode rbNode21 = new RBNode(tree,21);
        tree.insert(rbNode21 );
        RBNode rbNode95 = new RBNode(tree,95);
        tree.insert(rbNode95 );
        RBNode rbNode18 = new RBNode(tree,18);
        tree.insert(rbNode18 );  
        RBNode rbNode25 = new RBNode(tree,25);
        tree.insert(rbNode25);  
        RBNode rbNode66 = new RBNode(tree,66);
        tree.insert(rbNode66 );
        RBNode rbNode100= new RBNode(tree,100);
        tree.insert(rbNode100 );
        RBNode rbNode17 = new RBNode(tree,17);
        tree.insert(rbNode17 );
        RBNode rbNode24 = new RBNode(tree,24);
        tree.insert(rbNode24 );
        RBNode rbNode33 = new RBNode(tree,33);
        tree.insert(rbNode33 );
        tree.delete(rbNode16);
        assertEquals(tree.isBalanced(), true);
        tree.delete(rbNode55);
        assertEquals(tree.isBalanced(), true);
       tree.delete(rbNode14);
      /*  System.out.println(tree.getRoot());
        
        System.out.println(rbNode17 +"\t"+rbNode17.getColor()+"\t"+rbNode17.left()+"\t"+rbNode17.right());
        //System.out.println(tree.nullNode.getColor());
        //System.out.println(rbNode16 +"\t"+rbNode16.getColor()+"\t"+rbNode16.left()+"\t"+rbNode16.right());
       // System.out.println(rbNode14 +"\t"+rbNode14.getColor()+"\t"+rbNode14.left()+"\t"+rbNode14.right());
        System.out.println(rbNode10 +"\t"+rbNode10.getColor()+"\t"+rbNode10.left()+"\t"+rbNode10.right());
        System.out.println(rbNode15 +"\t"+rbNode15.getColor()+"\t"+rbNode15.left()+"\t"+rbNode15.right());
        System.out.println(rbNode12 +"\t"+rbNode12.getColor()+"\t"+rbNode12.left()+"\t"+rbNode12.right());
        //System.out.println(rbNode55 +"\t"+rbNode55.getColor()+"\t"+rbNode55.left()+"\t"+rbNode55.right());
        System.out.println(rbNode21 +"\t"+rbNode21.getColor()+"\t"+rbNode21.left()+"\t"+rbNode21.right());
        System.out.println(rbNode95 +"\t"+rbNode95.getColor()+"\t"+rbNode95.left()+"\t"+rbNode95.right());
        System.out.println(rbNode18 +"\t"+rbNode18.getColor()+"\t"+rbNode18.left()+"\t"+rbNode18.right());
        System.out.println(rbNode25 +"\t"+rbNode25.getColor()+"\t"+rbNode25.left()+"\t"+rbNode25.right());
        System.out.println(rbNode66 +"\t"+rbNode66.getColor()+"\t"+rbNode66.left()+"\t"+rbNode66.right());
        System.out.println(rbNode100 +"\t"+rbNode100.getColor()+"\t"+rbNode100.left()+"\t"+rbNode100.right());
        System.out.println(rbNode24 +"\t"+rbNode24.getColor()+"\t"+rbNode24.left()+"\t"+rbNode24.right());
        System.out.println(rbNode33 +"\t"+rbNode33.getColor()+"\t"+rbNode33.left()+"\t"+rbNode33.right());
        System.out.println(tree.root);*/
        assertEquals(tree.isBalanced(), true);
        //assertEquals(tree.getRoot(), rbNode17);
    }
    
}
