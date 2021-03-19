//409. 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 278 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长回文串
public class LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        // TO TEST
        String s = "ccc";
        int palindrome = solution.longestPalindrome(s);
        System.out.printf("字符串: %s, 可组成最大回文字符串长度: %d", s, palindrome);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeCustom(String s) {
        // 字符串判空操作
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 1;
        int sum = 0;
        // 辅助空间
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (charMap.containsKey(c)) {
                Integer count = charMap.get(c);
                charMap.put(c, count + 1);
            } else {
                charMap.put(c, 1);
            }
            // 成对出现即加2
            if (charMap.get(c) == 2) {
                sum += 2;
                charMap.remove(c);
            }
        }
        // 如果最终map还存在数据，只需要添加一个即可
        if (charMap.size() != 0) {
            sum += 1;
        }
        return sum;
    }

        public int longestPalindromeSolution(String s) {
            int[] count = new int[128];
            int length = s.length();
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                count[c]++;
            }

            System.out.printf("数组: %s%n", count);
            int ans = 0;
            for (int v: count) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0) {
                    ans++;
                }
            }
            return ans;
        }

        public int longestPalindrome(String s) {
            int[] count = new int[128];
            int length = s.length();
            int ans = 0;
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                count[c]++;
                if (count[c] == 2) {
                    ans += 2;
                    count[c] = 0;
                }
            }
            if (ans < s.length()) {
                ans += 1;
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}