"""
    // Time Complexity :O(2n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    push indexes into stack
    if T[i] > stack peek,update the result (resolved)
    else push it in stack

    circular array - i%n

"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # edge
        if len(nums) == 0 or nums is None: return [0]

        n = len(nums)
        result = [-1 for i in range(n)]
        stack = []

        for i in range(2 * n):
            while len(stack) != 0 and  nums[i % n] > nums[stack[-1]]:
                idx = stack.pop()
                result[idx] = nums[i % n]
            if i < n :
                stack.append(i)
        return result
