
"""
Time Complexity : O(3n)- worst case. 2n for traversing the array 2 times and n for popping all the elements out
of the stack 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
It is almost the same as  daily temp question. The only difference is that we traverse the array twice
to find out bigger number if any exists.
"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return nums
        
        l = len(nums)
        result = [-1 for i in range(l)]
        stack = []
        
        # 2*l since need to run twice
        for i in range(2 * l):
            # index out of bound since i is going out so i % l
            while stack and nums[i%l] > nums[stack[-1]]:
                idx = stack.pop()
                result[idx] = nums[i%l]
            
            # i < l only we have to push into the stack 
            if i < l:
                stack.append(i)
        
        return result
