package tiku;

import static java.lang.Math.min;

/**
 * className Q62
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019-09-06 18:12
 */
public class Q62 {

    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 0|| n == 0) return 0;
            long k=min(m,n)-1;
            long c=1;
            long i=1;
            for (n+=m-2; i<=k; c=c*(n--)/(i++));
            return (int) c;
        }
    }

}
