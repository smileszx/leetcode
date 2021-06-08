//206. 反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1637 👎 0

package leetcode.editor.cn;
//Java：反转链表
public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5, null)))));
        ListNode listNode = solution.reverseList(head);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
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

    public ListNode reverseList(ListNode head) {
        // 校验单链表为空或者只有一个节点，直接返回单链表
        if (head == null || head.next == null)
            return head;
        // 双指针法
        ListNode latter = null;
        ListNode forward = head;
        while (forward != null) {
            ListNode tmpNextNode = forward.next;
            // 修改next指向
            forward.next = latter;
            // 平移指针
            latter = forward;
            forward = tmpNextNode;
        }
        return latter;
    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode forward = head;
//        ListNode latter = null;
//        // 前置节点为空时，循环终止
//        while (forward != null) {
//            // 前置节点的下个节点存入缓存，否则前置节点修改next后则无法找到下个节点
//            ListNode temp = forward.next;
//            // 前置节点反指
//            forward.next = latter;
//            // 后置节点步进至前置节点位置
//            latter = forward;
//            // 前置节点后移一步
//            forward = temp;
//        }
//        // 最终后置节点为逆序成功的单链表
//        return latter;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}