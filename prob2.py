# Time Complexity : O(3N) -> O(N) first 2N is because we can circle back to 
# previous indices for the next greater element, and last N is for when we've dealt 
# with all elements, and we reach an index in nums that is equal to nums[top_of_stack],
# that means there is no greater element for this element 

# Space Complexity : O(N) in worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# here we use monotonically increasing stack approach
# while stack is not empty and nums[i % n] > nums[top of stack]
# pop top of stack and at that index, put nums[i % n]
# push index i on stack if i < n
# we have to i % n as we can circle back

from collections import deque
class Solution:

    def nextGreaterElement(self, nums):

        result = [-1] * len(nums)
        if nums is None or len(nums) == 0:
            return result
        
        n = len(nums)
        st = deque()
        for i in range(n * 2):

            while len(st) != 0 and nums[i % n] > nums[st[-1]]:

                top = st.pop()
                result[top] = nums[i % n]
            
            if i < n:
                st.append(i)

        return result