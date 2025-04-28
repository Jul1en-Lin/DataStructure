public class BinaryTree {
    static class TreeNote{
        public char val;
        public TreeNote left;
        public TreeNote right;

        public TreeNote(char val) {
            this.val = val;
        }
    }
    public TreeNote root;
    public TreeNote createTree(){
        TreeNote A = new TreeNote('A');
        TreeNote B = new TreeNote('B');
        TreeNote C = new TreeNote('C');
        TreeNote D = new TreeNote('D');
        TreeNote E = new TreeNote('E');

        A.left = B;
        B.left = D;
        A.right = C;
        C.left = E;
        root = A;
        return root;
    }

    /**
     * 前序遍历
     */
    public void preOrder(TreeNote root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNote root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(TreeNote root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    // 获取树中节点的个数  遍历o(N)
    public static int count;
    public void size(TreeNote root) {
        if (root == null) {
            return;
        }
        count++;
        size(root.left);
        size(root.right);
    }

    public int size2(TreeNote root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }
}
