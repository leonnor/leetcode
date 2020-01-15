package tiku;

/**
 * className Q231
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2020-01-15 23:17
 */
public class Q231 {

    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n<=0) return false;
            if((n&n-1)==0) return true;
            return false;
        }
    }
}
