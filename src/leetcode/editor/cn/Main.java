package leetcode.editor.cn;

import java.util.*;
public class Main {
    public static class Node {
        private int data;
        private Node next;
        
        public Node() {
            
        }

        public Node(int data) {
            this.data = data;
        }
    }
    
    public static Node toNode(List<Integer> arr) {
        if (arr.size() == 0) {
            return null;
        }
        Node head = new Node();
        
        for (int i = 0; i < arr.size(); i++) {
            Node tmp = new Node(arr.get(i));
            head.next = tmp;
            head = head.next;
        }
        return head;
    }
    
    public static void printNode(Node node) {
        Node t = node;
        while (t.next != null) {
            System.out.println(t.data);
            t = t.next;
        }
    }
    
    public static Node reverse(Node head) {
        Stack<Integer> s = new Stack<Integer>();
        Node tmp = head;
        while (tmp.next != null) {
            s.push(tmp.data);
            tmp = tmp.next;
        }

        Node res = new Node();
        while (!s.isEmpty()) {
            int data = s.pop();
            Node cur = new Node(data);
            res.next = cur;
            res = res.next;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Node node = toNode(Arrays.asList(1,2,3,4,5));
        printNode(node);
    }
}