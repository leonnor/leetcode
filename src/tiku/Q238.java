package tiku;

/**
 * className Q238
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/7/11 18:57
 */
public class Q238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {

            int left = 1;
            int right = 1;
            int len = nums.length;
            int[] output = new int[len];
            for(int i=0;i<len;i++){
                output[i] = left;
                left *= nums[i];
            }
            for(int j=len-1;j>=0;j--){
                output[j] *= right;
                right *= nums[j];
            }
            return output;
        }
    }
}
