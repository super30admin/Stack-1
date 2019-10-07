#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 10:49:13 2019

@author: tanvirkaur
"""

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [-1]*len(nums)
        stack = []
        for i in range (0, 2*len(nums)-1,1):
            tmp = nums[i%len(nums)]
            while stack and tmp > nums[stack[-1]]:
                res[stack.pop()] = tmp
            if i < len(nums):
                stack.append(i)
        return res 