//88. 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 816 👎 0

package leetcode.editor.cn;
//Java：合并两个有序数组
public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        // TO TEST
        int m = 3, n = 3;
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        solution.merge(nums1, m, nums2, n);
        for (int i=0; i< m+n; i++) {
            System.out.printf("%d ", nums1[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 不借助外部空间，假设nums1长度m+n
        // k为nums1最后一个元素索引下标
        int k = m + n -1;
        // nums1最后一个存在元素的索引下标
        int i = m - 1;
        // nums2最后一个元素索引下标
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // 如果数组2遍历完成,默认填充数组1剩余数据即可，可以不操作，本来就是数组1中覆盖操作
//        if (i >= 0) {
//            while (i >= 0) {
//                nums1[k--] = nums1[i--];
//            }
//        }
        // 如果数组1遍历完成，那么将全部数组2剩余元素添加到数组1剩余空位
        if (j >= 0) {
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}