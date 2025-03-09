/*
 * @lc app=leetcode id=17 lang=java
 * @lcpr version=30100
 *
 * [17] Letter Combinations of a Phone Number
 */

package leetcode.editor.en;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    // @lc code=start
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1, "");
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            map.put(0, "");
            for(int i = 0; i < digits.length(); i++){
                int num = digits.charAt(i) - '0';
                if(num != 1 && num != 0){
                    String temp = map.get(num);
                    if(res.isEmpty()){
                        for(int j = 0; j < temp.length(); j++){
                            res.add(String.valueOf(temp.charAt(j)));
                        }
                    }else{
                        int tempSize = res.size();
                        for(int j = 0; j < tempSize; j++){
                            for(int k = 0; k < temp.length(); k++){
                                res.add(res.get(j) + temp.charAt(k));
                            }
                        }
                        for(int j = 0; j < tempSize; j++){
                            res.remove(j);
                        }
                    }

                }
            }
            return res;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> res = solution.letterCombinations("23");
        System.out.println(res.toString());
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

