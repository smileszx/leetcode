// 106. 根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 508 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从中序与后序遍历序列构造二叉树
public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
        int [] inorder = new int[] {9,3,15,20,7};
        int [] postorder = new int[] {9,15,7,20,3};

        TreeNode treeNode = solution.buildTree(inorder, postorder);
        solution.inorderTraverseTreeNode(treeNode);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 校验中序和后序遍历数组元素个数是否相等
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new IllegalArgumentException("Incorrect input data.");
        }
        // 中序遍历结果缓存至Map
        Map<Integer, Integer> inorderMap = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i ++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeRecursion(postorder, 0, postLen - 1, inorderMap, 0, inLen - 1);
    }

    /**
     * 递归方式构造二叉树
     * @param postorder
     * @param postLeft
     * @param postRight
     * @param inorderMap
     * @param inLeft
     * @param inRight
     * @return leetcode.editor.cn.TreeNode
     * @throws
     * @author suzhengxiao
     * @date 2021/5/27 7:35 下午
     */
    public TreeNode buildTreeRecursion(int [] postorder, int postLeft, int postRight, Map<Integer, Integer> inorderMap, int inLeft, int inRight) {
        // 校验索引区间是否合理
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        // 后序遍历结果最后一个元素为根节点
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        // 获取中序遍历结果中，根节点的索引
        int pivotIndex = inorderMap.get(rootVal);
        // 中序遍历 inorder = [9,     3,     15,20,7]
        // 后序遍历 postorder = [9,     15,7,20,     3]
        // x - postLeft = pivotIndex - 1 - inLeft;
        // x = pivotIndex -inLeft + postLeft -1;
        root.left = buildTreeRecursion(postorder, postLeft, pivotIndex -inLeft + postLeft -1, inorderMap, inLeft, pivotIndex - 1);
        root.right = buildTreeRecursion(postorder, pivotIndex -inLeft + postLeft, postRight - 1, inorderMap, pivotIndex + 1, inRight);
        return root;
    }

    public void inorderTraverseTreeNode (TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverseTreeNode(root.left);
        System.out.printf("%d ", root.val);
        inorderTraverseTreeNode(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}