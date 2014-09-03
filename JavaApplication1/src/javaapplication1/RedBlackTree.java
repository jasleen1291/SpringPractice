package javaapplication1;


enum Color {

    BLACK, RED
}

public class RedBlackTree {

    public RedBlackTree() {
        nullNode = new RBNode(this);
        nullNode.setLeft(nullNode);
         nullNode.setRight(nullNode);
        root = nullNode;
    }

    public RBNode root, nullNode;

   public RBNode getRoot() {
        return root;
    }

    void setRoot(RBNode root) {
        this.root = root;
    }

   public void insert(RBNode z) {
        RBNode y = nullNode;
        RBNode x = getRoot();
        while (x != nullNode) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.left();
            } else {
                x = x.right();
            }
        }
        z.setParent(y);
        if (y == nullNode) {
            setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        z.setLeft(nullNode);
        z.setRight(nullNode);
        z.setRed();
        fixup(z);
    }

   public void inorder(RBNode x) {

        if (x != nullNode) {
            inorder(x.left());
            System.out.print(x.getKey() + " " + x.isRed() + "\t");
            inorder(x.right());
        }

    }

    void leftRotate(RBNode x) {
        
        
        RBNode y = x.right();
        
        x.setRight(y.left());//Turn y's left subtree into x's subtree
        if (y.left() != nullNode) {
            y.left().setParent(x);

        }
        y.setParent(x.parent());
        if (x.parent() == nullNode) {
            setRoot(y);
        } else if (x == x.parent().left()) {
            x.parent().setLeft(y);
        } else {
            x.parent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);

    }

    void rightRotate(RBNode x) {
       
        RBNode y = x.left();
        
        x.setLeft(y.right());//Turn y's left subtree into x's subtree
        if (y.right() != nullNode) {
            y.right().setParent(x);

        }
        y.setParent(x.parent());
        if (x.parent() == nullNode) {
            setRoot(y);
        } else if (x == x.parent().left()) {
            x.parent().setLeft(y);
        } else {
            x.parent().setRight(y);
        }
        y.setRight(x);
        x.setParent(y);

    }

    void iterativeInorder(RBNode x, int k) {

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

    RBNode successor(RBNode x) {
        if (x.right() != null) {
            x = x.right();
            while (x.left() != null) {
                x = x.left();
            }
            return x;
        } else {
            RBNode y = x.parent();
            while (y != null && x == y.right()) {
                x = y;
                y = y.parent();
            }
            return y;
        }
    }

    RBNode predecessor(RBNode x) {
        RBNode predc;
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

    void transplant(RBNode u, RBNode v) {
        if (u.parent() == nullNode) {
            setRoot(v);
        } else if (u == u.parent().left()) {
            u.parent().setLeft(v);
        } else {
            u.parent().setRight(v);
        }
        
            v.setParent(u.parent());
        
    }

   public void delete(RBNode z) {
        RBNode y = z,x;
        Color yOrigin = y.getColor();
        if (z.left() == nullNode) {
            x=z.right();
            transplant(z, z.right());
        } else if (z.right() == nullNode) {
            x=z.left();
            transplant(z, z.left());
        } else {
            y = minChild(z.right());
            yOrigin=y.getColor();
            x=y.right();
            if (y.parent() == z) {
               // System.out.println(y+" is p of" +x);
                x.setParent(y);
            }else
            {
                transplant(y, y.right());
                y.setRight(z.right());
                y.right().setParent(y);
            }
            transplant(z, y);
            y.setLeft(z.left());
            y.left().setParent(y);
            y.setColor(z.getColor());
        }
        if(yOrigin==Color.BLACK)
        {
            deleteFixup(x);
        }
    }

    void deleteFixup(RBNode x)
    {
     
        while(x!=root&& x.isBlack())
        {
            RBNode w;
           if(x.isLeft())
           {
               w=x.parent().right();
               if(w.isRed())
               {
                   w.setBlack();
                   x.parent().setRed();
                   leftRotate(x.parent());
                   w=x.parent().right();
               }
               if(w.left().isBlack()&&w.right().isBlack())
               {
                   w.setRed();
                   x=x.parent();
               }
               else {
                   if(w.right().isBlack())
                   {
                       w.left().setBlack();
                       w.setRed();
                       rightRotate(w);
                       w=x.parent().right();
                   }
                   w.setColor(x.parent().getColor());
                   x.parent().setBlack();
                   w.right().setBlack();
                   leftRotate(x.parent());
                   x=getRoot();
                   }
               
           }
           else
           {
                w=x.parent().left();
               if(w.isRed())
               {
                   w.setBlack();
                   x.parent().setRed();
                   leftRotate(x.parent());
                   w=x.parent().left();
               }
               if(w.right().isBlack()&&w.left().isBlack())
               {
                   w.setRed();
                   x=x.parent();
               }
               else {
                   if(w.left().isBlack())
                   {
                       w.left().setBlack();
                       w.setRed();
                       leftRotate(w);
                       w=x.parent().left();
                   }
                   w.setColor(x.parent().getColor());
                   x.parent().setBlack();
                   w.left().setBlack();
                   rightRotate(x.parent());
                   x=getRoot();
                   }
               
           
           }
        
        
        }
        x.setBlack();
        
    }
     public boolean isBalanced() { 
        int black = 0;     // number of black links on path from root to min
        RBNode x = root;
        while (x != nullNode) {
            if (!x.isRed()) black++;
            x = x.left();
        }
        return isBalanced(root, black);
    }
     private boolean isBalanced(RBNode x, int black) {
        if (x == nullNode) return black == 0;
        if (!x.isRed()) black--;
        // System.out.println(x.left+"\t"+black+"\t"+isBalanced(x.left, black)+"\t"+ x.right+"\t"+ isBalanced(x.right, black));
        return isBalanced(x.left(), black) && isBalanced(x.right(), black);
    } 
   

    RBNode minChild(RBNode x) {
        while (x.left() != nullNode) {
            x = x.left();
        }
        return x;
    }

    private void fixup(RBNode z) {
        while (z.parent().isRed()) {

            if (z.uncle() != nullNode && z.uncle().isRed()) {
                z.parent().setBlack();
                z.uncle().setBlack();
                z.grandParent().setRed();
                z = z.grandParent();
            } else {

                if (z.isRight() && z.parent().isLeft()) {
                    leftRotate(z.parent());
                    z = z.left();
                } else if (z.isLeft() && z.parent().isRight()) {
                    rightRotate(z.parent());
                    z = z.right();
                }
                z.parent().setBlack();
                z.grandParent().setRed();
                if (z.isLeft()) {
                    rightRotate(z.grandParent());
                } else {
                    leftRotate(z.grandParent());
                }
            }
        }
        getRoot().setBlack();
    }

   
   

}
