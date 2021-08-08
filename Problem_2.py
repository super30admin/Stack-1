from typing import List
from collections import deque
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1] * len(nums)
        if nums == None or len(nums) == 0:
            return result
        st = deque()
        n = len(nums)
        for i in range(2 * n):
            while len(st) > 0 and nums[i % n] > nums[st[-1]]:
                idx = st.pop()
                result[idx] = nums[i % n]
            if i < n:
                st.append(i)
        return result

# Time Complexity: O(4n)
# Space Complexity: O(n)