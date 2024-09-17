#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 10:51:10 2019

@author: tanvirkaur
"""

class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        lenT = len(T)
        if lenT == 0:
            return []
        res = [0]*lenT
        stack = []  
        for i in range(0,lenT):
            while stack and T[i] > stack[-1][1]:
                index , value= stack.pop()
                res[index] = i - index
            stack.append([i,T[i]])
        return res
            