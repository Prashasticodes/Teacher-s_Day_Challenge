/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int matchingNodes = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodes = 0;
        dfs(root);
        return matchingNodes;
    }

    // Returns an array of size 2: [subtreeSum, nodeCount]
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            matchingNodes++;
        }

        return new int[]{sum, count};
    }
}