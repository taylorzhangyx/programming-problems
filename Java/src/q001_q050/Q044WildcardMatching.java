package q001_q050;

public class Q044WildcardMatching {
	/**
	 * my solution uses a 2D array to record convert status from s to p
	 * however it can be optimized to O(n) space complexity
	 * just record the former status and use it
	 * 
	 * @author Yuxin Zhang
	 * @time 下午3:33:172017年3月19日2017
	 */
	public class Solution {
	    public boolean isMatch(String s, String p) {
	        if(s == null && p == null) return false;
	        int ls = s.length(), lp = p.length();
	        boolean[][] match = new boolean[ls+1][lp+1];
	        
	        //init
	        match[0][0] = true;
	        //empty s to p
	        for(int i = 0 ; i < lp; i++){
	            if(p.charAt(i) == '*' && match[0][i]){
	                match[0][i+1] = true;
	            }
	        }
	        for(int i = 0; i < ls; i++){
	            for(int j = 0 ; j < lp ; j++){
	                switch(p.charAt(j)){
	                    case '*':
	                        match[i+1][j+1] = match[i+1][j] || match[i][j] || match[i][j+1];
	                        break;
	                    case '?':
	                        match[i+1][j+1] = match[i][j];
	                        break;
	                    default:
	                        match[i+1][j+1] = s.charAt(i) == p.charAt(j) && match[i][j];
	                        break;  
	                }
	            }
	        }
	        
	        return match[ls][lp];
	    }
	}
	
	
	
	//https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution
	/**
	 * This solution is not like an understandable one. I didn't figure out why use startIdx and record that to forward s and p
	 * @param str
	 * @param pattern
	 * @return
	 */
	boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
}
}
