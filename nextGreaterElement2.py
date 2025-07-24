class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        minStack = []
        res = [-1] * len(nums)
        for i in range(2 * len(nums)):
            index = i % len(nums)
            while minStack and nums[minStack[-1] % len(nums)] < nums[index]:
                popIndex = minStack.pop()
                if popIndex < len(nums) and i - popIndex < len(nums):
                    res[popIndex] = nums[index]
            minStack.append(i)
        return res