package Note.cistern;


public class RedBlackTree {
    private static int BLACK = 1;
    private static final int RED = 0;

    private static Node root;

    private static class Node {
        private int color = RED;
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", color=" + color +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    interface SolutionInterface {
        void way(Node node);
    }

    enum Solution implements SolutionInterface{
        ONLY_CHANGE_COLOR {
            /**
             * 适用于：
             *   - 父节点和叔叔节点都为红色的情况；
             * 具体方法：
             *   - 把父节点和叔叔节点的颜色变为黑色，
             *   - 爷爷节点的颜色变为红色
             *   - 如果爷爷节点为根节点，爷爷节点颜色恢复黑色
             * @param node 当前新修改的节点
             */
            @Override
            public void way(Node node) {
                node.parent.parent.left.color = BLACK;
                node.parent.parent.right.color = BLACK;
                if(node.parent.parent.parent != null){
                    node.parent.parent.color = RED;
                }
            }
        },
        RIGHT_SPIN_LEFT_SPIN {
            /**
             * 适用于：
             *   - 无叔叔节点或叔叔节点为黑色
             *   - 父节点位于祖父节点的右子树
             *   - 新节点位于父节点左子树的情况
             * 具体方法：
             *   - 对当前节点的父节点进行右旋
             *   - 执行 LEFT_SPIN_CHANGE_COLOR
             * @param node 当前节点
             */
            @Override
            public void way(Node node) {
                Solution.rightSpin(node.parent);
                LEFT_SPIN_CHANGE_COLOR.way(node.right);
            }
        },
        LEFT_SPIN_CHANGE_COLOR {
            /**
             * 适用于：
             *   - 无叔叔节点或叔叔节点为黑色
             *   - 父节点位于祖父节点的右子树
             *   - 新节点位于父节点右子树的情况
             * 具体方法：
             *   - 将当前节点的父节点设置为黑色
             *   - 将当前节点的祖父节点设置为红色
             *   - 对祖父节点进行左旋
             * @param node 当前节点
             */
            @Override
            public void way(Node node) {
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                Solution.leftSpin(node.parent.parent);
            }
        },
        LEFT_SPIN_WITH_RIGHT_SPIN {
            /**
             * 适用于：
             *   - 无叔叔节点或叔叔节点为黑色
             *   - 父节点位于祖父节点的左子树
             *   - 新节点位于父节点右子树的情况
             * 具体方法：
             *   - 对当前节点的父节点进行左旋
             *   - 执行 RIGHT_SPIN_CHANGE_COLOR
             * @param node 当前节点
             */
            @Override
            public void way(Node node) {
                Solution.leftSpin(node.parent);
                RIGHT_SPIN_CHANGE_COLOR.way(node.left);
            }
        },
        RIGHT_SPIN_CHANGE_COLOR {
            /**
             * 适用于：
             *   - 无叔叔节点或叔叔节点为黑色
             *   - 父节点位于祖父节点的左子树
             *   - 新节点位于父节点左子树的情况
             * 具体方法：
             *   - 将当前节点的父节点设置为黑色
             *   - 将当前节点的祖父节点设置为红色
             *   - 对祖父节点进行右旋
             * @param node 当前节点
             */
            @Override
            public void way(Node node) {
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                Solution.rightSpin(node.parent.parent);
            }
        },
        PASS {
            /**
             * 异常情况
             * @param node 当前节点
             */
            @Override
            public void way(Node node) {

            }
        };


        /**
         * 左旋
         *   - 旋转前的右子节点变成旋转后的父节点
         *   - 旋转前的父节点（轴）变为旋转后父节点的左子节点
         *   - 旋转前轴的右子节点的右子节点旋转后变为轴的右子节点
         *   - 旋转前右子节点的左子树变成旋转后左子节点的右子树
         *   - 其他不变
         * @param node 以该节点为轴旋转
         */
        private static void leftSpin(Node node) {
            Node nextFather = node.right;
            nextFather.parent = node.parent;
            node.right = node.right.left;
            nextFather.left = node;
            connectParent(node, nextFather);
        }

        /**
         * 将变换后的树和它上面的节点连接
         * @param node 变换前的轴
         * @param nextFather 变换后的子树
         */
        private static void connectParent(Node node, Node nextFather) {
            // 如果变换的是根节点，就把root赋值成变换后的节点
            if(node.parent != null) {
                if(node.parent.data > node.data) {
                    node.parent.left = nextFather;
                } else {
                    node.parent.right = nextFather;
                }
            } else {
                RedBlackTree.root = nextFather;
            }
            node.parent = nextFather;
        }

        /**
         * 右旋
         *   - 旋转前的左子节点变成旋转后的父节点
         *   - 旋转前左子节点的右子树变成旋转后右子节点的左子树
         * @param node 旋转轴。
         */
        private static void rightSpin(Node node) {
            Node nextFather = node.left;
            nextFather.parent = node.parent;
            node.left = node.left.right;
            nextFather.right = node;
            connectParent(node, nextFather);
        }
    }

    public RedBlackTree(int rootData){
        root = new Node(rootData);
        root.color = BLACK;
    }

    /**
     * 通过一个整形数组快速构建红黑树
     * @param data 要创建树的元素
     */
    public RedBlackTree(int [] data) {
        assert data.length >= 1: "data的长度至少为1";
        root = new Node(data[0]);
        root.color = BLACK;
        for (int i = 1; i < data.length; i++) {
            this.append(data[i]);
        }
    }


    /**
     * 判断插入新节点后红黑树结构是否需要变化
     * 根据红黑树的定义，两个红色节点不能连接
     * @param root 插入的新节点
     * @return 返回true表示插入新节点后破坏了红黑树的结构，
     *         需要通过旋转变色来纠正，否则不需要修改。
     */
    private boolean checkStruct(Node root) {
        return root.color == RED && root.parent.color == RED;
    }

    /**
     * 确定该以哪种方式变换当前树，使之满足红黑树的条件
     * @param node 当前新加入的，使红黑树结构错误的节点
     * @return 返回解决办法
     */
    private Solution determineSolution(Node node) {
        int fatherColor = node.parent.color;
        int uncleColor;
        // 如果父亲是爷爷的右子树
        if(node.parent.data > node.parent.parent.data){
            uncleColor = node.parent.parent.left == null? BLACK: node.parent.parent.left.color;
            if(fatherColor == RED && uncleColor == BLACK){
                if(node.data < node.parent.data){
                    return Solution.RIGHT_SPIN_LEFT_SPIN;
                } else {
                    return Solution.LEFT_SPIN_CHANGE_COLOR;
                }
            }
        } else {
            uncleColor = node.parent.parent.right == null? BLACK: node.parent.parent.right.color;
            if(fatherColor == RED && uncleColor == BLACK){
                // 插入的节点是父节点的左子节点
                if(node.data < node.parent.data){
                    return Solution.RIGHT_SPIN_CHANGE_COLOR;
                } else {
                    return Solution.LEFT_SPIN_WITH_RIGHT_SPIN;
                }
            }
        }

        // 如果父节点和叔叔节点都是红色
        if(fatherColor == RED && uncleColor == RED){
            return Solution.ONLY_CHANGE_COLOR;
        }
        return Solution.PASS;
    }

    private void changeTree(Node node) {
        Solution solution = determineSolution(node);
        solution.way(node);
        if(node.parent != null && node.parent.parent != null && checkStruct(node.parent.parent)) {
            changeTree(node.parent.parent);
        }
    }


    /**
     * 通过递归往红黑树中插入一个新节点
     * @param root 要插入的树的根节点
     * @param data 新节点的值
     */
    private void insert(Node root, int data) {
        if(root.data > data) {
            if(root.left == null) {
                Node node = new Node(data);
                root.left = node;
                node.parent = root;
                if(checkStruct(node)) {
                    changeTree(node);
                }
            } else {
                insert(root.left, data);
            }
        }else {
            if(root.right == null) {
                Node node = new Node(data);
                root.right = node;
                node.parent = root;
                if(checkStruct(node)) {
                    changeTree(node);
                }
            } else {
                insert(root.right, data);
            }
        }
    }

    public Node append(int data) {
        insert(root, data);
        return root;
    }

    public Node append(int[] data) {
        for (int datum : data) {
            append(datum);
        }
        return root;
    }

    public Node getRoot(){
        return root;
    }

    public static void main(String[] args) {
        int[] data = {16, 8, 11, 13, 15, 17, 22, 25, 27};
        RedBlackTree redBlackTree = new RedBlackTree(data);
        System.out.println(redBlackTree.getRoot());
    }


}
