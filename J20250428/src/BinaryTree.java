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

    /**
     * 获取叶子节点的个数
     * @param root 遍历
     * @return count
     */
    public static int LeafNodeCount;
    public void getLeafNodeCount(TreeNote root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            LeafNodeCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    /**
     * 获取叶子节点的个数2
     * @param root 子问题思路
     */
    public int getLeafNodeCount2(TreeNote root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     * 获取第 K 层有多少个节点
     * @param root
     * @param k
     * @return
     */
    public int getLevelNodeCount(TreeNote root,int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getLevelNodeCount(root.left,k-1) + getLevelNodeCount(root.right,k-1);
    }

    /**
     * 获取树的高度
     * @param root
     * @return
     */
    public int getHeight(TreeNote root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.max(leftH,rightH) + 1;
    }

    public TreeNote find (TreeNote root,char val){
        if (root == null){
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNote note = find(root.left, val);
        if (note != null) {
            return note;
        }
        TreeNote note1 = find(root.right, val);
        if (note1 != null) {
            return note1;
        }
        return null;
    }

    /*
    检查两棵树是否相同
     */
    public boolean isSameTree(TreeNote p,TreeNote q) {
        //一个为空 一个不为空
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        //两个为空 是一样的
        if (p == null && q == null) {
            return true;
        }
        //两个不为空但值不一样
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
