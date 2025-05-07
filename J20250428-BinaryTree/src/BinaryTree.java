import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode{

        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public TreeNode root;
    public TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    /**
     * 前序遍历
     */
    public void preOrder(TreeNode root) {
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
    public void inOrder(TreeNode root) {
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
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    /**
     * 层序遍历
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            System.out.print(cur.val + " ");
            //需要考虑子树是否是空树的情况
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            queue.poll();
        }
    }

    /**
     * 层序遍历2
     */
    public List<List<Character>> levelOrderBottom(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Character> listRow = new ArrayList<>();
            int size = queue.size();
            while (size != 0) {
                TreeNode cur = queue.poll();
                listRow.add(cur.val);
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(listRow);
        }
        return ret;
    }


    // 获取树中节点的个数  遍历o(N)
    public static int count;
    public void size(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        size(root.left);
        size(root.right);
    }

    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }



    /**
     * 获取叶子节点的个数
     */
    public static int LeafNodeCount;
    public void getLeafNodeCount(TreeNode root) {
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
    public int getLeafNodeCount2(TreeNode root) {
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
    public int getLevelNodeCount(TreeNode root,int k) {
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
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.max(leftH,rightH) + 1;
    }

    public TreeNode find (TreeNode root,char val){
        if (root == null){
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode note = find(root.left, val);
        if (note != null) {
            return note;
        }
        TreeNode note1 = find(root.right, val);
        if (note1 != null) {
            return note1;
        }
        return null;
    }

    /*
    检查两棵树是否相同
     */
    public boolean isSameTree(TreeNode p,TreeNode q) {
        //一个为空 一个不为空
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        //两个为空 是一样的
        if (p == null && q == null) {
            return true;
        }
        //两个不为空但值不一样
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubTree(TreeNode root,TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root,subRoot)){
            return true;
        }
        //递归
        if (isSubTree(root.left,subRoot)){
            return true;
        }
        if (isSubTree(root.right,subRoot)){
            return true;
        }
        return false;
    }

    /*
    翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        /*if ((root.left != null && root.right == null) || (root.right != null && root.left == null)){
            return null;
        }*/
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //TODO:如何用返回值做？
    public TreeNode invertTree2(TreeNode root) {
        return null;
    }

    /*
    判断是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    private boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if ((leftTree != null && rightTree == null) || (leftTree == null && rightTree != null)) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        /*if (leftTree.val == rightTree.val) {
            return true;
        }*/ //error
        if (leftTree.val != rightTree.val) {
            return false;
        }
        //到了这里证明leftTree.val == rightTree.val 需要继续走下去
        return isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left);
    }

    /**
     * 判断是否为完全二叉树
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        return true;
    }

    /**
     * 判断是否为平衡二叉树
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight2(root) >= 0;
    }
    private int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight2(root.left);
        if (leftH < 0) {
            return -1;
        }
        int rightH = getHeight2(root.right);
        if (rightH < 0) {
            return -1;
        }
        if (Math.abs(leftH - rightH) <= 1 && leftH >= 0 && rightH >= 0) {
            return Math.max(leftH,rightH) + 1;
        }else {
            return -1;
        }
    }
}
