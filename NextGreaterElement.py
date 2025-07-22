# // Time Complexity : o(n) 
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# // Your code here along with comments explaining your approach
# So we go through the array twice to simulate the circular nature.
# For each number, we use a stack to track the next greater element efficiently.
# As soon as we find a bigger one, we update and move on, skipping repeated work.
from typing import List
# class Solution:
#     def nextGreaterElements(self, nums: List[int]) -> List[int]:
#         n = len(nums)
#         st = []
#         res = [-1]*n
#         for i in range(2*n):
#             while st and nums[i%n] > nums[st[-1]]:
#                 popped = st.pop()
#                 res[popped] = nums[i%n]
#             if i<n:
#                 st.append(i)
            
#         return res

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        st = []
        res = [-1]*n
        for i in range(2*n):
            while st and nums[i%n] > nums[st[-1]]:
                popped = st.pop()
                res[popped] = nums[i%n]
            if i<n:
                st.append(i)
            elif st and st[-1] == i%n:
                break
        return res
        
        