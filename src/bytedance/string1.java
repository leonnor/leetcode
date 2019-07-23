package bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * className string1
 * description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 * 滑动窗口法
 *
 * @author ln
 * @version 1.0
 * @date 2019/5/11 13:23
 */
public class string1 {

    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }
}
