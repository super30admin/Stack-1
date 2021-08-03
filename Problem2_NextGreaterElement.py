'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 503. Next Greater Element II


# https://leetcode.com/problems/next-greater-element-ii/
#-----------------
# Time Complexity: 
#-----------------
# O(N): Need to iterate over the entire once in the worst case 
#------------------
# Space Complexity: 
#------------------
# O(N) - Need to store stack of max size N in the worst case, where N is the length of input

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n
        stack = []
        
        for i in range(2*n-1, -1, -1):
            while len(stack) > 0 and nums[stack[-1]] <= nums[i % n]:
                stack.pop()
            
            if len(stack) == 0:
                result[i % n] = -1
            else:
                result[i % n] = nums[stack[-1]]
            
            stack.append(i % n)
        
        return result
                