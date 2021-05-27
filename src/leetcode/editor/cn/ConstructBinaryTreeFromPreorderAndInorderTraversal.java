//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 1051 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        solution.preorderTraverseTreeNode(treeNode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            // 校验前序和中序遍历数组长度是否相等
            int preLength = preorder.length;
            int inLength = inorder.length;
            if (preLength != inLength) {
                throw new IllegalArgumentException("Incorrect input data.");
            }

            // 缓存中序遍历结果到Map数据结构
            Map<Integer, Integer> inorderMap = new HashMap<>(inLength);
            for (int i = 0; i < inLength; i++) {
                inorderMap.put(inorder[i], i);
            }

            return buildTreeRecursion(preorder, 0, preLength - 1, inorderMap, 0, inLength - 1);
        }

        /**
         * 递归构建二叉树
         * @param preorder
         * @param preLeft
         * @param preRight
         * @param inorderMap
         * @param inLeft
         * @param inRight
         * @return leetcode.editor.cn.TreeNode
         * @throws
         * @author suzhengxiao
         * @date 2021/5/27 2:17 下午
         */
        public TreeNode buildTreeRecursion(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> inorderMap, int inLeft, int inRight) {

            // 校验区间边界是否合理
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            // 前序遍历可以确定根节点
            int rootVal = preorder[preLeft];
            TreeNode root = new TreeNode(rootVal);
            // 根据根节点值，获取根节点在中序遍历数组中索引
            int pivotIndex = inorderMap.get(rootVal);
            // 根据左右子树索引区间关系递归构建子树
            // 设定前序遍历数组，左子树右侧索引为x，x - （preLeft + 1） = （pivotIndex - 1）- inLeft
            // x = pivotIndex - inLeft + preLeft ；
            root.left = buildTreeRecursion(preorder, preLeft + 1, pivotIndex - inLeft + preLeft, inorderMap, inLeft, pivotIndex - 1);
            root.right = buildTreeRecursion(preorder, pivotIndex - inLeft + preLeft + 1, preRight, inorderMap, pivotIndex + 1, inRight);
            return root;
        }

        public void preorderTraverseTreeNode (TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.printf("%d ", root.val);
            preorderTraverseTreeNode(root.left);
            preorderTraverseTreeNode(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}