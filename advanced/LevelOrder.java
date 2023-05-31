

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> levelOrderList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (A == null)
           return levelOrderList;

        queue.add(A);

        while (!queue.isEmpty()) {

            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();

                if (tempNode.left != null)
                    queue.add(tempNode.left);

                if (tempNode.right != null)
                    queue.add(tempNode.right);

                level.add(tempNode.val);
            }

            levelOrderList.add(level);

        }

        return levelOrderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        LevelOrder levelOrder = new LevelOrder();
        levelOrder.levelOrder(root).forEach(x -> System.out.println(x));
    }
}
