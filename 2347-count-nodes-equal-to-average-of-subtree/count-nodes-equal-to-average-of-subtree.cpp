/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include <utility>

using namespace std;

class Solution {
private:
    int matchingNodes = 0;

    // Returns a pair<int, int>: {subtreeSum, nodeCount}
    pair<int, int> dfs(TreeNode* node) {
        if (!node) {
            return {0, 0};
        }

        auto left = dfs(node->left);
        auto right = dfs(node->right);

        int sum = left.first + right.first + node->val;
        int count = left.second + right.second + 1;

        if (sum / count == node->val) {
            matchingNodes++;
        }

        return {sum, count};
    }

public:
    int averageOfSubtree(TreeNode* root) {
        matchingNodes = 0;
        dfs(root);
        return matchingNodes;
    }
};