package q001_q050;

public class Q042TrappingRainWater {

	/**
	 * the idea of mine is, find the highest point in the array. 
	 * dp from left to right and from right to left to the highest point to calculate traped water.
	 * @author Yuxin Zhang
	 * @time 下午2:41:522017年3月19日2017
	 */
	
	public class Solution {
	    public int trap(int[] height) {
	        if(height == null || height.length <= 2) return 0;
	        int water = 0, pod = 0;
	        int highest = 0, index = -1;
	        int len = height.length;
	        int l = 0, r = len - 1;
	        for(int i = 0 ; i < len; i++){
	            if(height[i] > highest){
	                highest = height[i];
	                index = i;
	            }
	        }
	        
	        //scan from left to right
	        for(int i = 0; i <= index; i++){
	            if(height[i] <= height[l]){
	                water += height[l] - height[i];
	            }
	            else{
	                l = i;
	            }
	        }
	        
	        //scan from right to left
	        for(int i = len - 1; i >= index; i--){
	            if(height[i] <= height[r]){
	                water += height[r] - height[i];
	            }
	            else{
	                r = i;
	            }
	        }
	        
	        return water;
	    }
	}
	
	
	
	/**
	 * 2 pointer solution combined previous together in one while
	 * @author Yuxin Zhang
	 * @time 下午2:44:452017年3月19日2017
	 */
	public class Solution2 {
	    public int trap(int[] heights) {
	        
	        if ( heights.length <= 2 ) { return 0; }
	        
	        int left = 0, right = heights.length-1, totalArea = 0;
	        int leftMaxHeight = heights[left], rightMaxHeight = heights[right];
	        
	        while ( left < right ) {
	            if ( heights[left] < heights[right] ) {
	                leftMaxHeight = Math.max(leftMaxHeight, heights[++left]);
	                totalArea += leftMaxHeight-heights[left];
	            } else {
	                rightMaxHeight = Math.max(rightMaxHeight, heights[--right]);
	                totalArea += rightMaxHeight-heights[right];
	            } 
	        }
	        return totalArea;
	    }
	}
	
	/**
	 * this idea posted by @StefanPochmann and rewrote by @sandhyas 
	 * One thing noticed here is that 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length - 1;
        int level = 0, water = 0, index = 0;
        while(n > 0)
        {
            int lower = height[index] < height[index + n] ? height[index++] : height[index + n];
			if(lower > level)
				level = lower;
			water += level - lower;
			n--;
        }
        return water;
    }
}
