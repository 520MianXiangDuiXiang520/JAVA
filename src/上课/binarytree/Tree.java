package 上课.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree<T> {
    private Node<T>  rootNode;
    static int index = 0;
    private List<T> input;

    public Tree() {}

    public Tree(List<T> input) {
        this.input = input;
    }

    /**
     * 递归创建二叉树
     * @param root 根节点
     * @param index 值索引
     * @return int 索引值
     */
    private int createTree(Node<T> root, int index) {
        if(input.get(index) == null) {
            return index + 1;
        } else {
            root.setValue(input.get(index));
            Node<T> left = new Node<>();
            root.setLeftChild(left);
            int leftIndex = createTree(left, index + 1);

            Node<T> right = new Node<>();
            root.setRightChild(right);
            return createTree(right, leftIndex);
        }
    }

    /**
     * 创建二叉树
     */
    public Node<T> createTree() {
        rootNode = new Node<>();
        createTree(rootNode, 0);
        deleteNull(rootNode);
        return rootNode;
    }

    /**
     * 返回根节点
     * @return Node
     */
    public Node<T> getRootNode() {
        return this.rootNode;
    }

    /**
     * 前序遍历
     * @param root 根节点
     */
    private void preorderTraversal(Node<T> root) {
        if (root != null) {

            System.out.print(root.getValue());

            preorderTraversal(root.getLeftChild());
            preorderTraversal(root.getRightChild());
        }
    }

    public void preorderTraversal() {
        preorderTraversal(rootNode);
        System.out.println();
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    private void midsequenceTraversal(Node<T> root){
        if (root != null) {
            midsequenceTraversal(root.getLeftChild());
            System.out.print(root.getValue());
            midsequenceTraversal(root.getRightChild());
        }
    }

    public void midsequenceTraversal() {
        midsequenceTraversal(rootNode);
        System.out.println();
    }

    /**
     * 后序遍历
     * @param root 根节点
     */
    private void postorderTraversal(Node<T> root) {
        /**
         * 后序遍历
         */
        if (root != null) {
            postorderTraversal(root.getLeftChild());
            postorderTraversal(root.getRightChild());
            System.out.print(root.getValue());
        }
    }

    public void postorderTraversal() {
        postorderTraversal(rootNode);
        System.out.println();
    }

    /**
     * 删除空节点
     * @param root 根节点
     */
    private void deleteNull(Node<T> root) {
        if(root.getLeftChild().getValue() == null)
            root.setLeftChild(null);
        else
            deleteNull(root.getLeftChild());
        if(root.getRightChild().getValue() == null)
            root.setRightChild(null);
        else
            deleteNull(root.getRightChild());
    }

    /**
     * 根据值查找节点
     * @param root 根节点
     * @param value 节点值
     * @return 查找到的节点对象
     */
    private Node<T> findNode(Node<T> root, T value) {
        Node<T> node;
        if (root == null)
            return null;
         else {
             if(root.getValue() == value) {
                 return root;
             } else {
                 node = findNode(root.getLeftChild(), value);
                 if(node != null) {
                     return node;
                 } else {
                     return findNode(root.getRightChild(), value);
                 }
             }
        }
    }

    public Node<T> findNode(T value) {
        return findNode(rootNode, value);
    }


    /**
     * 判断是否是叶子节点
     * @param value 查找值
     * @return 没找到或不是叶子节点返回false,叶子节点返回true
     */
    public boolean isLeave(T value) {
        Node<T> node = findNode(rootNode, value);
        if(node != null)
            return node.getLeftChild() == null && node.getRightChild() == null;
        return false;
    }

    /**
     * 计算深度
     * @return int
     */
    public int height() {
        return height(rootNode);
    }

    private int height(Node<T> subtree){
        if (subtree==null){
            return 0;
        }else {
            int l=height(subtree.getLeftChild());
            int r=height(subtree.getRightChild());
            return (l>r) ? (l+1):(r+1);//返回并加上当前层
        }
    }

    public Node<T> addLeftChild(Node<T> node, T newValue) {
        Node<T> getNode = findNode(node.getValue());
        if(getNode != null) {
            Node<T> newNode = new Node<T>();
            newNode.setValue(newValue);
            newNode.setLeftChild(getNode.getLeftChild());
            newNode.setRightChild(getNode.getRightChild());
            getNode.setLeftChild(newNode);
        } else {
            System.out.println("没有这个节点");
        }
        return rootNode;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "d", null, "e", null, null, "f", "g", null, null, null, "c", null, null));
        Tree<String> tree = new Tree<String>(list);
        tree.createTree();
        System.out.println("前序遍历：");
        tree.preorderTraversal();
        System.out.println("中序遍历：");
        tree.midsequenceTraversal();
        System.out.println("后序遍历：");
        tree.postorderTraversal();
        System.out.println("查找节点：");
        Node<String> find = tree.findNode("b");
        System.out.println(find);
        System.out.println("树深度:");
        System.out.println(tree.height());
        System.out.println("添加节点：");
        Node<String> addFind = tree.findNode("b");
        tree.addLeftChild(addFind, "h");
        tree.preorderTraversal();
    }

}
