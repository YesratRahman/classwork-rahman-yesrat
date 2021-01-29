
public class NodeRelatedProblem {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

    //My Version
        public static int rangeSumBST(TreeNode root, int low, int high) {
            int sum = 0;
            if(root == null){ //empty tree return 0
                return 0;
            }
            if(root.val > low ){
                sum += rangeSumBST(root.left, low, high);
            }
            //if root val is less than high, call right subtree
            if(root.val < high){
                sum += rangeSumBST(root.right, low, high);
            }
            if(root.val >= low && root.val <= high){
                sum += root.val;
            }
            return sum;
        }

        //David's Version
    public static int rangeSumBST1(TreeNode root, int low, int high) {
        int sum = 0;
        if(low <= root.val && high >=root.val) sum = root.val;
        if(root.left != null) sum+= rangeSumBST1(root.left, low, high);
        if(root.right != null) sum+= rangeSumBST1(root.right, low, high);

        return sum;
    }



}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}