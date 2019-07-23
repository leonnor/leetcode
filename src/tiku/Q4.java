package tiku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * className Q4
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019-07-17 09:17
 */
public class Q4 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
            Collections.sort(list);
            if (list.size() % 2 == 0) {
                return (double) (list.get(list.size() / 2) +
                        list.get(list.size() / 2 - 1)) / 2.0;
            } else {
                return (double) list.get(list.size() / 2);
            }
        }
    }
}
