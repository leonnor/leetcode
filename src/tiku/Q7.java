package tiku;

/**
 * className Q7
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019-07-23 13:42
 */
public class Q7 {

    class Solution {
        public int reverse(int x) {

            /**
             ret 保存旧的翻转中间值, temp 保存新的翻转过程中间值
             依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10
             无法得到上一轮的翻转结果 ret
             **/
            int ret = 0;
            while(x != 0) {
                int temp = ret*10 + x%10;
                if(temp / 10 != ret)
                    return 0;
                ret = temp;
                x /= 10;
            }
            return ret;
        }
    }
}
