

public class DeleteNodeFromBST {

    private TreeNode deleteNode(TreeNode root, int k) {
        //Assumption:- will search and delete the node and then balance the tree 
        // and return the root node of LST OR RST which got rebalanced
        
        //If node to be deleted is not found  
        if (root == null)
            return null;
        
        if( k > root.val) 
            root.right = deleteNode(root.right,k);
        else if (k < root.val)
            root.left = deleteNode(root.left, k);
        else {
            //root.val == k
            //Case 1 :- its leaf node 
            if (isLeafNode(root))
                return null;

            // case 2:- Single child
            if (root.left == null) {
                //return non empty child
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            //case 3:- 2 children
            TreeNode leftMaxNode = getLeftMaxNode(root.left);
            root.val = leftMaxNode.val;
            root.left = deleteNode(root.left,leftMaxNode.val);
        }

        return root;
        
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private TreeNode getLeftMaxNode(TreeNode root) {
        TreeNode leftMaxNode = root;
        while (root.right != null) {
            leftMaxNode = root.right;
            root = root.right;
        }

        return leftMaxNode;
    }
    
    public static void main(String[] args) {
        DeleteNodeFromBST deleteNodeFromBST = new DeleteNodeFromBST();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        deleteNodeFromBST.deleteNode(root, 2);
        
    }
}
