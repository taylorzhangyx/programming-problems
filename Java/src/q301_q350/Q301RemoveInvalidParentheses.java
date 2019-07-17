package q301_q350;

import java.util.LinkedList;
import java.util.List;

//Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
//Note: The input string may contain letters other than the parentheses ( and ).
//
//Examples:
//"()())()" -> ["()()()", "(())()"]
//"(a)())()" -> ["(a)()()", "(a())()"]
//")(" -> [""]


public class Q301RemoveInvalidParentheses {
	
	public class Solution {
	    public List<String> removeInvalidParentheses(String s) {
	    	List<String> res = new LinkedList<>();
	    	helper(res, new StringBuilder(s), 0, 0, new char[]{'(', ')'});
	    	return res;
	    }

		private void helper(List<String> res, StringBuilder sb, int last_i, int last_j, char[] cs) {
			for(int stack = 0, i = 0 ; i < sb.length(); i++){
				if(sb.charAt(i) == cs[0]) stack++;
				if(sb.charAt(i) == cs[1]) stack--;
				if(stack >= 0) continue;
				for(int j = last_j; j <= i; j++){
					if(sb.charAt(j) == cs[1] && (j == last_j || sb.charAt(j-1) != cs[1]))//remove duplicate
					 helper(res, new StringBuilder(sb.substring(0, j) + sb.substring(j+1, sb.length())), i, j, cs);
				}
				return;
			}
			sb.reverse();
			if(cs[0] == '('){
				helper(res, sb, 0,0, new char[]{')', '('});
				}
			else{
				res.add(sb.toString());
			}
		}
	}
}
