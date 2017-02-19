package q051_q100;

import java.util.LinkedList;
import java.util.List;

import dataStructure.Interval;

public class Q057InsertInterval {
//	Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//	You may assume that the intervals were initially sorted according to their start times.
//
//	Example 1:
//	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//	Example 2:
//	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	
	
	//2 ideas
	//1. find the correct spot and insert, then merge together
	//2. merge first, measure new interval and current interval to find when to insert
	public class Solution {
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        intervals.add(binarySearch(intervals,newInterval), newInterval);
	        for(int i = 0 ; i < intervals.size()-1;){
	        	if(intervals.get(i).end >= intervals.get(i+1).start){
	        		intervals.get(i).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
	        	}
	        	else i++;
	        }
	        return intervals;
	    }

		private int binarySearch(List<Interval> intervals, Interval newInterval) {
			int start = 0 , end = intervals.size();
			while(start < end){
				int middle = start + (end - start)/2;
				if(intervals.get(middle).start >= newInterval.start){
					end = middle;
				}
				else{
					start = middle+1;
				}
			}
			return start;
		}
	}
	
	
	public class Solution2{
		public List<Interval> insert(List<Interval> intervals, Interval newInterval){
			List<Interval> res = new LinkedList<Interval>();
			for(Interval curr : intervals){
				if(newInterval == null || curr.end < newInterval.start){
					res.add(curr);
				}
				else if(curr.start > newInterval.end){
					res.add(newInterval);
					res.add(curr);
					newInterval = null;
				}
				else{
					newInterval.start = Math.min(newInterval.start, curr.start);
					newInterval.end = Math.max(newInterval.end, curr.end);
				}
			}
			return res;
		}
	}
	
}
