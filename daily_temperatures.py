# -*- coding: utf-8 -*-
"""
TC:O(N) where N is the list of entries in T
SC:O(N) where N is the list of entries in T
"""

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack=[]
        res=[0]*len(T)
        for i in range(len(T)):
            while stack and T[i]>stack[-1][1]:
                idx=stack[-1][0]
                res[idx]=i-stack.pop()[0]
            stack.append([i,T[i]])
        return stack