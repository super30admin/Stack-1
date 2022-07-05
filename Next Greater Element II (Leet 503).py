'''
Using Monotonic Stack
Time: O(2n) --> O(n) (max two traversals per element and loop runs twice)
Space: O(n)
'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        if nums is None or len(nums) == 0:
            return None
        
        res = [-1 for _ in range(len(nums))]
        st = list()
        n = len(nums)
        
        for i in range(2*len(nums)):
            
            while len(st) != 0 and nums[st[-1]] < nums[i%n]:
                curr = st.pop()
                res[curr] = nums[i%n]
            if i < len(nums):
                st.append(i%n)
        
        return res