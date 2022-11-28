# TC : O(n)
# SC : O(1)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        rtnData = [-1] * len(nums)
        mstack = []

        for i in range(2 * (len(nums))):
            while len(mstack) != 0 and nums[mstack[-1]] < nums[i % len(nums)]:
                greater = nums[i % len(nums)]
                rtnData[mstack[-1]] = greater
                mstack.pop()

            if i < len(nums):
                mstack.append(i)

        return rtnData