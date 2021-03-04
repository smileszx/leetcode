package leetcode.editor.cn;

/**
 * 列表节点
 * @author suzhengxiao
 * @date 2021/1/30 3:16 下午
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
