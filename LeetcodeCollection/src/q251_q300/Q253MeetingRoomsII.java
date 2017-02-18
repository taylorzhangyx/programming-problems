package q251_q300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import dataStructure.Interval;;

public class Q253MeetingRoomsII {

//	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//	For example,
//	Given [[0, 30],[5, 10],[15, 20]],
//	return 2.
	
	public class Solution4 {
	    public int minMeetingRooms(Interval[] intervals) {
	        int[] starts = new int[intervals.length];
	        int[] ends = new int[intervals.length];
	        for(int i=0; i<intervals.length; i++) {
	            starts[i] = intervals[i].start;
	            ends[i] = intervals[i].end;
	        }
	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        int rooms = 0;
	        int endsItr = 0;
	        for(int i=0; i<starts.length; i++) {
	            if(starts[i]<ends[endsItr])
	                rooms++;
	            else
	                endsItr++;
	        }
	        return rooms;
	    }
}
	
	
	public class Solution3 {
	    public int minMeetingRooms(Interval[] intervals) {
	    	if(intervals.length == 0) return 0;
	    	//sort the array based on start time
	    	Arrays.sort(intervals, new Comparator<Interval>(){
	    		@Override
	    		public int compare(Interval i1, Interval i2){
	    			if(i1.start != i2.start) return i1.start - i2.start;
	    			else return i1.end - i2.end;
	    		}
	    	});
	    	
	    	PriorityQueue<Interval> rooms = new PriorityQueue<>(new Comparator<Interval>(){
	    		@Override
	    		public int compare(Interval i1, Interval i2){
	    			return i1.end-i2.end;
	    		}
	    	});
	    	//initialize pq
	    	rooms.add(intervals[0]);
	    	for(int i = 1 ; i < intervals.length; i++){
	    		//check if this meeting can be added into this room
	    		if(intervals[i].start >= rooms.peek().end){
	    			//if can, pop the top room out and update the end time, then push it back
	    			//this make sure that the pq is in order
	    			Interval curr = rooms.poll();
	    			curr.end = intervals[i].end;
	    			rooms.add(curr);
	    		}
	    		else{
	    			//if can't, give this meeting a new room
	    			rooms.offer(intervals[i]);
	    		}
	    	}
	    	//the size is the number of room we need
	    	return rooms.size();
	    }
	}
	
	
	public class Solution1 {
	    public int minMeetingRooms(Interval[] intervals) {
	    	if(intervals == null || intervals.length == 0) return 0;
	        Arrays.sort(intervals, new Comparator<Interval>(){
	        	//sort based on start point
	        	//if start times are equal, compare end time
	        	@Override
	        	public int compare(Interval i1, Interval i2){
	        		if(i1.start != i2.start) return i1.start - i2.start;
	        		else return i1.end - i2.end;
	        	}
	        });
	        int count = 0;//the number of room we need
	        for(int i = 0 ; i < intervals.length ; i++ ){
	        	if(intervals[i] == null) continue;//check if there is a meeting to schedule
	        	Interval curr = intervals[i];
	        	for(int j = i+1; j < intervals.length; j++){
	        		if(intervals[j] != null && intervals[j].start >= curr.end){
	        			//update the meeting end time for current room
	        			curr.end = intervals[j].end;
	        			//mark scheduled meeting as null
	        			intervals[j] = null;
	        		}
	        	}
	        	//mark current meeting as scheduled
	        	intervals[i] = null;
	        	count++;
	        }
	        return count;
	    }
	}
	
	
	public class Solution2 {
	    public int minMeetingRooms(Interval[] intervals) {
	        //sort based on start
	        Arrays.sort(intervals, new Comparator<Interval>(){
	            @Override
	            public int compare(Interval i1, Interval i2){
	                if(i1.start != i2.start) return i1.start - i2.start;
	                else return i1.end - i2.end;
	            }
	        });
	        //convert arry into list
	        LinkedList<Interval> list = new LinkedList<Interval>();
	        for(int i = 0 ; i < intervals.length; i++){
	            list.add(intervals[i]);
	        }
	        int count = 0;//room number we need
	        while(!list.isEmpty()){
	        	//pop out the first meeting and arrange it
	            Interval curr = list.remove(0);
	            for(int i = 0; i < list.size();){
	            	// for every meeting left, check if can be placed in the same room
	                Interval next = list.get(i);
	                if(curr.end <= next.start){
	                    curr.end = next.end;
	                    list.remove(i);//if can then pop it
	                }
	                else i++;//if can't visit the next meeting
	            }
	            count++;//this room is fully scheduled
	        }
	        return count;
	    }
	}
	
}
