public class BinarySearchTree {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;

    /**
     * 查找
     *  时间复杂度：
     *      最坏：o(N)——单分支树
     *      最好：o(logN)——满二叉树/完全二叉树
     * @param key
     * @return
     */
    public TreeNode searchTree (int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < key) {
                cur = cur.right;
            }else if (cur.val > key){
                cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 插入法
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else if (cur.val > key){
                parent = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        TreeNode newNode = new TreeNode(key);
        if (parent.val > key) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        return true;
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else if (cur.val > key){
                parent = cur;
                cur = cur.left;
            }else {
                removeNode(parent,cur);
                return;
            }
        }
    }
    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = root.right;
            }else if (cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null){
            if (cur == root) {
                root = root.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode targetParent = cur;
            TreeNode target = targetParent.right;
            //找到右树中最左边的节点
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;

            if (target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}
