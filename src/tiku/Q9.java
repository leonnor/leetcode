package tiku;

/**
 * className Q9
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019-07-23 16:17
 */
public class Q9 {

    class Solution {
        public boolean isPalindrome(int x) {

            if (x < 0) return false;
            int y = 0, dit = 0;
            int temp = x;
            while (temp != 0) {
                dit = temp % 10;
                y = y * 10 + dit;
                temp /= 10;
            }
            return x == y;
        }

    }
}
