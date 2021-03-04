//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5568 👎 0

package leetcode.editor.cn;
//Java：两数相加
public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        // 进位，因为每个节点数字均为1位数字，相加进位为0或1
        int carry = 0;
        // 遍历链表节点，只要两个链表其中一个不为空，继续遍历
        while (l1 != null || l2 != null) {
            // 链表节点值，三目运算符，如果为空则补0
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 两个数相加，同时加上进位，进位都是用到下一位使用
            int sum = n1 + n2 + carry;
            // 结果链表节点，头节点为空，此时将计算结果与10求余，放在头和尾节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                // 头节点不为空，则挂到尾节点后面
                tail.next = new ListNode(sum % 10);
                // 尾节点指针向后移动一位
                tail = tail.next;
            }
            // 计算进位值，相加结果大于等于10则进位等于1
            carry = sum / 10;
            // 以上计算结束，判断当前节点如果不为空，指针向后移动一步
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 全部计算结束，如果进位值为1，那么需要在结果链表节点后再加一位
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}