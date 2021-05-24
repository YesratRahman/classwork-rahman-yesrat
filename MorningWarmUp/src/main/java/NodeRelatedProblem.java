import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodeRelatedProblem {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
       // System.out.println(rangeSumBST(root, 7, 15));
       // System.out.println(countNodes(root));


    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


//    //https://leetcode.com/problems/house-robber-iii/
//    public static int rob(TreeNode root) {
//
//    }


    //https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
    public static int maxDepth(Node root) {
        int depth = 0;
        if (root == null) return 0;
        for (Node childNode: root.children) {
                depth = Math.max(depth, maxDepth(childNode)); //depth get the highest of all the child subtree
        }
        return depth + 1; //return the depth based on the root of current root

    }

    //Eliot's version
    public static int maxDepth2(Node root) {
        if(root == null)return 0;
    List<Integer> maxDepths = new ArrayList<>();
    maxDepthHelper(root, maxDepths, 0);
    return maxDepths.stream().max(Integer::compare).get();
    }
    public static void maxDepthHelper(Node root, List<Integer> maxDepths, int depth){
        depth++;
        if(root.children.size() == 0){
            maxDepths.add(depth);
        }
        else {
            for(Node node : root.children){
                maxDepthHelper(node, maxDepths, depth);
            }
        }
    }


        //https://leetcode.com/problems/count-complete-tree-nodes/
    //Recursive
    public static int countNodes(TreeNode root) {
        int count = 1 ; //already have the root, then go to the left and right side

        if(root == null)return 0;
         count += countNodes(root.left);
            count += countNodes(root.right);
            return count;

            //in one line
       // return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);

    }

    //Iterative solution (Does not work : time limit)

    public static int countNodes1(TreeNode root) {
        int count = 0 ;
        if(root == null) return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
            while(!list.isEmpty()){
                if(root.left != null && root.right != null)count++;
                if(root.left !=null ) list.add(root.left);
                if(root.right !=null ) list.add(root.right);

            }

        return count;

        // start by getting a lower bound for the number of nodes by just following the left branch
        // (doubling the min every time)
        // once you've figured out a minimum bound
        // (because you can't go left anymore to a deeper level) the maximum bound = min * 2 -1
        //then you can start doing a binary search to see which count in between those is the right one
        //(the trick there is going from a count you want to check to a series of left or right turns)

//        if(root == null)return 0;
//
//        int min = 0;
//        TreeNode current = root;
//        while(current.left != null ){
//            min *= 2;
//            current = current.left;
//        }
//        int max = min * 2 - 1;
//        while (max > min){
//            int mid = (min + max) / 2 ;
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

