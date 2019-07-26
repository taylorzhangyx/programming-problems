#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
#
# algorithms
# Medium (28.57%)
# Likes:    5888
# Dislikes: 338
# Total Accepted:    1M
# Total Submissions: 3.5M
# Testcase Example:  '"abcabcbb"'
#
# Given a string, find the length of the longest substring without repeating
# characters.
# 
# 
# Example 1:
# 
# 
# Input: "abcabcbb"
# Output: 3 
# Explanation: The answer is "abc", with the length of 3. 
# 
# 
# 
# Example 2:
# 
# 
# Input: "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
# 
# 
# 
# Example 3:
# 
# 
# Input: "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3. 
# ⁠            Note that the answer must be a substring, "pwke" is a
# subsequence and not a substring.
# 
# 
# 
# 
# 
#
class Solution:

    def containsDuplicateChar(self, s: str) -> bool:
        charSet =[] 
        for i in s:
            if i not in charSet:
                charSet.append(i)
            else:
                return True
        return False

    def lengthOfLongestSubstring(self, s: str) -> int:
        maxlen = 0
        for i in range(len(s)):
            for j in range(i+1, len(s)):
                if not self.containsDuplicateChar(s[i:j]):
                    maxlen = max(maxlen, j-i)
        return maxlen
