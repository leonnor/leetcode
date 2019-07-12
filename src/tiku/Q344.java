package tiku;

/**
 * className Q344
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/7/4 16:18
 */
public class Q344 {

    class Solution {
        public void reverseString(char[] s) {

            int len = s.length;
            for (int i = 0; i < len/2; i++){
                char a;
                a = s[i];
                s[i] = s[len - i - 1];
                s[len - i - 1] = a;
            }
        }
    }
}
