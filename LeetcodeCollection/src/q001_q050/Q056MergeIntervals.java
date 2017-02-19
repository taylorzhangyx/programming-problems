package q001_q050;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import dataStructure.Interval;

/**
 * 
	Given a collection of intervals, merge all overlapping intervals.
	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 * @author Yuxin Zhang
 * @time 上午10:37:172017年2月18日2017
 */

/**
 * learn:
 * 	sort-> use Arrays.sort for array, and Collections.sort for collections implementation such as List
 * @author Yuxin Zhang
 * @time 上午11:08:112017年2月18日2017
 */
//use build in sort and merge neighbor intervals
public class Q056MergeIntervals {
	public class Solution1 {
	    public List<Interval> merge(List<Interval> intervals) {
	    	//sort based on start
	    	intervals.sort(new Comparator<Interval>(){
	    		@Override
	    		public int compare(Interval i1, Interval i2){
	    			return i1.start - i2.start;
	    		}
	    	});
	    	
	    	//for each interval, check if can merge with neighbor
	    	for(int i = 0; i < intervals.size()-1; i++){
    			Interval stay = intervals.get(i);
	    		while(i < intervals.size()-1 && intervals.get(i).end >= intervals.get(i+1).start){
	    			//if can merge, remove neighbor and set new end point
	    			Interval merged = intervals.remove(i+1);//list.remove takes O(n), not efficient
	    			stay.end = Math.max(stay.end, merged.end);
	    		}
	    	}
	        return intervals;
	    }
	}
	
	//use super comparator to define compare & construct new res
	public class Solution2 {
	    public List<Interval> merge(List<Interval> intervals) {
	    	//check input validation
	    	if(intervals.size() <=1) return intervals; 
	    	
	    	//sort based on start
	    	intervals.sort((i1, i2) ->(i1.start - i2.start));
	    	
	    	//result list
	    	List<Interval> res = new LinkedList<Interval>();
	    	
	    	//mark current start and end
			int start = intervals.get(0).start, end = intervals.get(0).end;
	    	
	    	//for each interval, check if can merge with neighbor
	    	for(int i = 1; i < intervals.size(); i++){
	    		Interval curr = intervals.get(i);
	    		if(curr.start > end){
	    			res.add(new Interval(start,end));
	    			start = curr.start;
	    			end = curr.end;
	    		}
	    		else{
	    			end = Math.max(end, curr.end);
	    		}
	    	}
	    	res.add(new Interval(start,end));
	        return res;
	    }
	}
	

	//use super comparator to define compare & change old intervals to be new result
	public class Solution3 {
	    public List<Interval> merge(List<Interval> intervals) {
	    	//check input validation
	    	if(intervals.size() <=1) return intervals; 
	    	
	    	//sort based on start
//	    	intervals.sort((i1, i2) ->(i1.start - i2.start));
	    	Collections.sort(intervals, (i1,i2) -> (i1.start - i2.start));
	    	
	    	//result list
	    	List<Interval> res = new LinkedList<Interval>();
	    	
	    	//extract first interval
	    	Interval curr = intervals.get(0);
	    	
	    	//for each interval, check if can merge with neighbor
	    	for(int i = 1; i < intervals.size(); i++){
	    		Interval next = intervals.get(i);
	    		if(next.start > curr.end){
	    			res.add(curr);
	    			curr = next;
	    		}
	    		else{
	    			curr.end = Math.max(curr.end, next.end);
	    		}
	    	}
	    	res.add(curr);
	        return res;
	    }
	}
	
}
