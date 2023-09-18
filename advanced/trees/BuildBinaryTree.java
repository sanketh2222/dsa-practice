

import java.util.HashMap;
import java.util.Map;

public class BuildBinaryTree {

    // Value of Node vs Index
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] A, int[] B) {
        // PreOrder ( Root Left Right), In order(Left Root Right)
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        TreeNode root = constructTree(A, 0, (A.length - 1), B, 0, B.length - 1);
        return root;
    }

    public TreeNode constructTree(int[] preOrder, int spr, int epr,
            int[] inOrder, int sin, int ein) {

        if (sin > ein)
            return null;

        int idx = map.get(preOrder[spr]);
        TreeNode root = new TreeNode(preOrder[spr]);
        int a = idx - sin;
        root.left = constructTree(preOrder, spr + 1, spr + a, inOrder, sin, idx - 1);
        root.right = constructTree(preOrder, spr + a + 1, epr, inOrder, idx + 1, ein);

        return root;

    }

    public static void main(String[] args) {
        BuildBinaryTree binaryTree = new BuildBinaryTree();
        int[] A = { 1, 2, 3 };
        int[] B = { 2, 1, 3 };
        TreeNode root = binaryTree.buildTree(A, B);
        System.out.println(root);
    }
}
