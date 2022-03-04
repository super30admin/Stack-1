"""
Given a circular integer array nums (i.e., the next element of 
nums[nums.length - 1] is nums[0]), return the next greater number 
for every element in nums.

The next greater number of a number x is the first greater number 
to its traversing-order next in the array, which means you could 
search circularly to find its next greater number. 
If it doesn't exist, return -1 for this number.
"""

# Time Complexity : O(2 * n) = O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        res = [-1] * n
        
        if nums == None:
            return res
        
        st = []
        
        for i in range(2*n):
            
            while len(st) != 0 and nums[i%n] > nums[st[-1]]:
                popped = st.pop()
                res[popped] = nums[i%n]
                
            if i < n:
                st.append(i)
                    
        return res
        
        