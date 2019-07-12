package tiku;

import java.util.TreeSet;

/**
 * className Q804
 * description
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 *
 * @author ln
 * @version 1.0
 * @date 2019/5/18 15:21
 */
public class Q804 {

    class Solution {
        public int uniqueMorseRepresentations(String[] words) {

            String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                    "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

            TreeSet<String> set = new TreeSet<>();
            for (String word : words){
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < word.length(); i++){
                    res.append(codes[word.charAt(i) - 'a']);
                }
                set.add(res.toString());
            }
            return set.size();
        }
    }
}
