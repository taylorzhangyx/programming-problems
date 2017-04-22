package q001_q050;


/*
 * cycle sort: 
 * wiki: https://en.wikipedia.org/wiki/Cycle_sort
 * geeksforgeeks: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0ahUKEwjDjcPz3OHSAhVH-GMKHdFMAhcQFggiMAE&url=http%3A%2F%2Fwww.geeksforgeeks.org%2Fcycle-sort%2F&usg=AFQjCNE16bDLO5MxnRNVoGe58QXGxs6zLQ&sig2=B4yg-GYT0Z-K9Y5plP4Wig
 */

public class Q041FirstMissingPositive {

	public class Solution {
	    public int firstMissingPositive(int[] nums) {
	        int len = nums.length;
	        for(int i = 0 ; i < len; i++){
	            while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]){
	                swap(nums, i, nums[i]-1);
	            }
	        }
	        
	        for(int i = 0 ; i < len; i++){
	            if(nums[i]-1 != i) return i+1;
	        }
	        return len+1;
	    }
	    
	    private void swap(int[] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	}
	
}
