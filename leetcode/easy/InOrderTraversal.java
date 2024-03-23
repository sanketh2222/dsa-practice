package easy;

import java.util.List;

import models.TreeNode;

import java.util.ArrayList;


public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderLst = new ArrayList<>();
        inorder(root, inorderLst);

        return inorderLst;

    }

    private void inorder(TreeNode root, List<Integer> inorderLst) {
        if (root == null) {
            return;
        }

        inorder(root.left, inorderLst);
        inorderLst.add(root.val);
        inorder(root.right, inorderLst);
    }
}
