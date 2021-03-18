//20. 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2245 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：有效的括号
public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
        String str = "{}[]";
        boolean result = solution.isValid(str);
        System.out.printf("字符串: %s, 判断是否有效字符串: %s%n", str, result);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 如果字符串长度为奇数,不能保证字符串成对出现
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> strStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                strStack.push(')');
            } else if (c == '[') {
                strStack.push(']');
            } else if (c == '{') {
                strStack.push('}');
            } else if (strStack.empty() || c != strStack.pop()) {
                return false;
            }
        }

        return strStack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}