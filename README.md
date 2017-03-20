# Leetcodes Questions and Answers 
Write and Collected by Yuxin Zhang

## Table of Content
- [1. Two Sum](#1-two-sum)
- [2. Add Two Numbers](#2-add-two-numbers)
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
```java
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0 ; i < nums.length; i++){
        if(map.containsKey(target - nums[i])){
            return new int[]{map.get(target-nums[i]), i};
        }
        else{
            map.put(nums[i], i);
        }
    }
    return new int[]{0,0};
}
```

## 2 Add Two Numbers 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

### Idea
Use dummy node to handle beginning, use carry to add lists till the shorter one ends.
Find the rest node add with carry till the end of list
Handle carry at last

Java
```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dummy = new ListNode(0), next = dummy;
    //add num togather
    while(l1 != null && l2 != null){
        int sum = l1.val + l2.val + carry;
        l1 = l1.next;
        l2 = l2.next;
        next.next = new ListNode(sum%10);
        next = next.next;
        carry = sum/10;
    }
    ListNode rest = l1 != null ? l1 : l2;
    //find the rest list and add with carry
    while(rest != null){
        int sum = rest.val + carry;
        rest = rest.next;
        next.next = new ListNode(sum%10);
        next = next.next;
        carry = sum/10;
    }
    //take care of carry
    if(carry != 0) next.next = new ListNode(carry);
    return dummy.next;
}
```


OR
Scan two lists till no valid node to be handle and carry is 0
only when != null, add node value and move to next node


Python
```python
def addTwoNumbers(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    dummy = next = ListNode(0)
    carry = 0
    while(l1 or l2 or carry):
        if l1:
            carry += l1.val
            l1 = l1.next
        if l2:
            carry += l2.val
            l2 = l2.next
        carry,val = divmod(carry,10)
        next.next = ListNode(val)
        next = next.next
    return dummy.next
```

Java
```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), n = dummy;
    int carry = 0;
    while(l1 != null || l2 != null || carry != 0){
        if(l1 != null){
            carry += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            carry += l2.val;
            l2 = l2.next;
        }
        n.next = new ListNode(carry%10);
        n = n.next;
        carry = carry/10;
    }
    return dummy.next;
}
```

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
