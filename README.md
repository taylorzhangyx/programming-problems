# Leetcodes Questions and Answers 
Write and Collected by Yuxin Zhang

## Table of Content
- [1. Two Sum](#1-two-sum)
- [41. First Missing Positive](#41-first-missing-positive)


## 1 Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

### Idea
##### Hashing
Store the scaned numbers and look for the difference in teh hash table to find a pair to sum as `target`.
Time O(n)
Space O(n)

Python:
```python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        for i in range(len(nums)):
            if (target - nums[i]) in map:
                return [i, map[target - nums[i]]]
            else:
                map[nums[i]] = i
```
Java:

##### Sort and find
Sort the array and find pair with two pointers
Left pointer moves only when the current sum is smaller than target;
while right pointer move only when the current sum is larger than target.
Phthon:



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
