//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 255 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：排序数组
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        // TO TEST
        int[] nums = new int[]{21, 127, 13, 3};
        solution.sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 快速排序 1：基本快速排序

        /**
         * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
         */
        private static final int INSERTION_SORT_THRESHOLD = 7;

        private final Random RANDOM = new Random();

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            quickSort(nums, 0, len - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            // 小区间使用插入排序
            if (right - left <= INSERTION_SORT_THRESHOLD) {
                insertionSort(nums, left, right);
                return;
            }

            int pIndex = partition(nums, left, right);
            quickSort(nums, left, pIndex - 1);
            quickSort(nums, pIndex + 1, right);
        }

        /**
         * 对数组 nums 的子区间 [left, right] 使用插入排序
         * @param nums  给定数组
         * @param left  左边界，能取到
         * @param right 右边界，能取到
         */
        private void insertionSort(int[] nums, int left, int right) {
            for (int i = left + 1; i <= right; i++) {
                int temp = nums[i];
                int j = i;
                while (j > left && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
        }

        private int partition(int[] nums, int left, int right) {
            int randomIndex = RANDOM.nextInt(right - left + 1) + left;
            swap(nums, left, randomIndex);

            // 基准值
            int pivot = nums[left];
            int lt = left;
            // 循环不变量：
            // all in [left + 1, lt] < pivot
            // all in [lt + 1, i) >= pivot
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    lt++;
                    swap(nums, i, lt);
                }
            }
            swap(nums, left, lt);
            return lt;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}