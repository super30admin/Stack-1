# time - O(3n)
# space - O(n)
# des- similar to the problem of daily temperature, but have to traverse the array again(2n).
# trick- using mod to get the index of the elements in the nums array
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        stack = []
        res = [-1] * len(nums)
        for i in range(2 * len(nums)):
            while stack and nums[i % len(nums)] > nums[stack[len(stack) - 1]]:
                res[stack.pop()] = nums[i % len(nums)]
            if i < len(nums):
                stack.append(i)
        return res
