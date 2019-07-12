package tiku;

/**
 * className Q557
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/7/4 16:42
 */
public class Q557 {
    class Solution {
        public String reverseWords(String s) {

            char[] rev = s.toCharArray();
            int head = 0, tail = 0;
            while(tail<s.length()){
                while(tail<s.length()&&s.charAt(tail)!=' '){
                    tail++;
                }
                int i = head,j=tail-1;
                while(i < j){
                    char temp = rev[i];
                    rev[i++] = rev[j];
                    rev[j--] = temp;
                }
                tail += 1;
                head = tail;
            }
            return new String(rev);
        }
    }
}
