package advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RightViewBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> levelOrdList = new ArrayList<>();

        queue.add(A);

        while (!queue.isEmpty()) {

            int size = queue.size();
            ArrayList<Integer> level = null;

            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                level = new ArrayList<>();

                if (tempNode.left != null)
                    queue.add(tempNode.left);

                if (tempNode.right != null)
                    queue.add(tempNode.right);

                level.add(tempNode.val);

            }

            levelOrdList.add(level);
        }
        return (ArrayList<Integer>) levelOrdList.stream().map(x -> x.get(x.size() - 1)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        RightViewBinaryTree binaryTree = new RightViewBinaryTree();
        binaryTree.solve(root).forEach(System.out::println);

    }

}
