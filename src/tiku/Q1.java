package tiku;

/**
 * className Q1
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019-12-26 14:59
 */
public class Q1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            int[] answer = new int[2];
            for(int i = 0; i < len; i++){
                int ans = target - nums[i];
                for(int j = i + 1; j<len;j++){
                    if (nums[j] == ans){
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
            return answer;
        }
    }
}
