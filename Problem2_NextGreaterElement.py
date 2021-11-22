# Time Complexity: O(n), where n - length of input array
# Space Complexity: O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums or len(nums) == 0:
            return []

        n = len(nums)
        result = [-1 for x in range(n)]
        stack = []

        # Since nums is circular array, iterate through the array twice
        for i in range(2 * n):

            # If curr val is greater than val of the idx from stack, update the result for that idx
            while stack and nums[i % n] > nums[stack[-1]]:
                idx = stack.pop()
                result[idx] = nums[i % n]

            # Else, push the index into stack until a greater val is found, (only in first pass)
            if i < n:
                stack.append(i)

        return result