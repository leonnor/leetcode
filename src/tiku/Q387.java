package tiku;

/**
 * className Q387
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/7/7 9:00
 */
public class Q387 {
    class Solution {
        public int firstUniqChar(String s) {

            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (freq[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
