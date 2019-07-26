#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#
# https://leetcode.com/problems/reverse-integer/description/
#
# algorithms
# Easy (25.39%)
# Likes:    2305
# Dislikes: 3543
# Total Accepted:    747K
# Total Submissions: 2.9M
# Testcase Example:  '123'
#
# Given a 32-bit signed integer, reverse digits of an integer.
# 
# Example 1:
# 
# 
# Input: 123
# Output: 321
# 
# 
# Example 2:
# 
# 
# Input: -123
# Output: -321
# 
# 
# Example 3:
# 
# 
# Input: 120
# Output: 21
# 
# 
# Note:
# Assume we are dealing with an environment which could only store integers
# within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
# of this problem, assume that your function returns 0 when the reversed
# integer overflows.
# 
#
import math
class Solution:
    def reverse(self, x: int) -> int:
        INT_MAX = 2 ** 31 - 1
        INT_MIN = - 2 ** 31
        if x > INT_MAX or x < INT_MIN:
            return 0
        reverse = 0
        carry = 1
        if x < 0:
            carry = -1
            x *= -1
        while x != 0:
            pop = x % 10
            x = math.floor(x / 10)
            print(x)
            if reverse > INT_MAX / 10 or reverse == INT_MAX / 10 and pop > 7:
                return 0
            elif reverse < INT_MIN / 10 or reverse == INT_MIN / 10 and pop < -8:
                return 0
            reverse = reverse * 10 + pop
        return reverse * carry

            

