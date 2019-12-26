package tiku;

/**
 * className Q11
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019-12-26 15:16
 */
public class Q11 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int area = (height.length - 1) * Math.min(height[0], height[height.length - 1]);
            while (left != right){
                int newArea = (right - left) * Math.min(height[left], height[right]);
                if (area < newArea) area = newArea;
                if (height[left] <= height[right]) left++;
                else right--;
            }
            return area;
        }
    }
}
