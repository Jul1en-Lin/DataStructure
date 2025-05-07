public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();


        System.out.println("=====");
        boolean balanced = binaryTree.isBalanced(root);
        System.out.println(balanced);
        System.out.println();

        binaryTree.levelOrder(root);
    }
}
