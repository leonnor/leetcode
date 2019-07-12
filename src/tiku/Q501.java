package tiku;

import java.util.*;

/**
 * className Q501
 * description TODO
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author ln
 * @version 1.0
 * @date 2019/5/19 12:08
 */
public class Q501 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public int[] findMode(TreeNode root) {

            if (root == null){
                return new int[0];
            }
            int[] ans = new int[100000];
            int i = 0;
            preOrder(root);
            Object maxValue = getMaxValue(map);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (maxValue.equals(entry.getValue())) {
                    ans[i] = entry.getKey();
                    i++;
                }
            }
            int count = 0;
            for (int j = 0; j < ans.length; j++){
                if (ans[j] != 0){
                    count++;
                }
            }
            if (ans[0] == 0){
                count++;
            }
            int[] res = new int[count];
            for (int j = 0; j < count; j++){
                res[j] = ans[j];
            }
            return res;
        }

        /**
         * 遍历树并把每个数出现的次数记录到map中，类似桶排序
         * @param root
         */
        private void preOrder(TreeNode root){
            if (root == null) {
                return;
            }
            if (map.containsKey(root.val)){
                map.put(root.val, map.get(root.val) + 1);
            } else {
                map.put(root.val, 1);
            }
            preOrder(root.left);
            preOrder(root.right);
        }

        /**
         * 获取出现最多的次数
         * @param map
         * @return
         */
        private Object getMaxValue(Map<Integer, Integer> map){

            if (map.size() == 0){
                return null;
            }

            Collection<Integer> c = map.values();
            Object[] objects = c.toArray();
            Arrays.sort(objects);
            return objects[objects.length - 1];
        }
    }
}
