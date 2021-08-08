# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# use stack to keep track of previous elements and traverse twice to
# to handle the circular array condition
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []
        
        result = [-1]*len(nums)
        n = len(nums)
        st = []
        for i in range(0,2*n):
            
            while len(st) != 0 and nums[i % n] > nums[st[len(st) - 1]]:
                idx = st.pop()
                
                result[idx] = nums[i%n]
                
            if i < n:
                st.append(i)
        return result
                
        
        