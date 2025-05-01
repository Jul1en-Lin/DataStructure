public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNote root = binaryTree.createTree();
        BinaryTree.TreeNote d = binaryTree.find(root, 'D');
        System.out.println(d.val);
    }
}
