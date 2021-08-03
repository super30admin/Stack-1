'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 739. Daily Temperatures


# https://leetcode.com/problems/daily-temperatures/

#-----------------
# Time Complexity: 
#-----------------
# O(N): Need to iterate over the entire twice in the worst case 
#------------------
# Space Complexity: 
#------------------
# O(N) - Need to store stack of max size N in the worst case, where N is the length of input

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        if n == 0:
            return []
        result = [0] * n
        stack = []
        
        for i in range(n):
            while len(stack) > 0 and temperatures[stack[-1]] < temperatures[i]:
                top = stack.pop()
                result[top] = i - top
            
            stack.append(i)
        
        return result
                