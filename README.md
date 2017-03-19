# Leetcodes Questions and Answers 
Write and Collected by Yuxin Zhang

## Table of Content
- [41 First Missing Positive](#41-first-missing-positive)

## 41 First Missing Positive
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

```java
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
```
