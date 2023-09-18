

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InOrderTreeTraversal {
    
    private List<Integer> inorderTraversal = new ArrayList<>();

    public int[] inorderTraversal(TreeNode A) {
        //In-order : Left Root Right
        inOrder(A);
        return inorderTraversal.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode A) {
        if (A == null)
            return;
        
        inOrder(A.left);
        inorderTraversal.add(A.val);
        inOrder(A.right);

    }
    
    public static void main(String[] args) {
        InOrderTreeTraversal inOrderTreeTraversal = new InOrderTreeTraversal();
        int[] arr = {1, 3, 2};
        // inOrderTreeTraversal.inOrder(arr);
        
    }
}
