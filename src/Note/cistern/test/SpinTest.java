package Note.cistern.test;

import Note.cistern.RedBlackTree;

@SuppressWarnings("all")
public class SpinTest {
    void leftSpin(Node node) {
        Node nextFather = node.right;
        node.right = node.right.left;
        nextFather.left = node;
        if(node.parent != null) {
            if(node.parent.data > node.data) {
                node.parent.left = nextFather;
                nextFather.parent = node.parent.left;
            } else {
                node.parent.right = nextFather;
                nextFather.parent = node.parent.right;
            }
        } else {

        }
        node.parent = nextFather;
    }

     void rightSpin(Node node) {
        Node nextFather = node.left;
        nextFather.parent = null;
        node.left = node.left.right;

        nextFather.right = node;

        if(node.parent != null) {
            if(node.parent.data > node.data) {
                node.parent.left = nextFather;
                nextFather.parent = node.parent.left;
            } else {
                node.parent.right = nextFather;
                nextFather.parent = node.parent.right;
            }
        } else {

        }
         node.parent = nextFather;

    }
    public static void main(String[] args) {
//        Node root = new Node(19);
//        Node root1 = new Node(12);
//        Node root2 = new Node(30);
//        Node root3 = new Node(5);
//        Node root4 = new Node(13);
//        Node root5 = new Node(35);
//        Node root6 = new Node(10);
//        Node root7 = new Node(7);
//        Node root8 = new Node(6);
//        root.left = root1;
//        root.right = root2;
//        root1.parent = root;
//        root2.parent = root;
//        root1.left = root3;
//        root1.right = root4;
//        root3.parent = root1;
//        root4.parent = root1;
//        root2.right = root5;
//        root5.parent = root2;
//
//        root3.left = root6;
//        root3.right = root7;
//        root6.parent = root3;
//        root7.parent = root3;
//
//        root7.left = root8;
//        root8.parent = root7;
//        System.out.println(root);
        Node node = new Node(12);
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(10);
        node.left = node1;
        node1.parent = node;

        node.right = node2;
        node2.parent = node;

        node1.right = node3;
        node3.parent = node1;
        new SpinTest().leftSpin(node1);
        System.out.println(node);

    }
}
