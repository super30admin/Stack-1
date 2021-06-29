class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        if nums is None: return -1
        callstack = []
        out = [-1] * len(nums)
        n = len(nums)

        for id in range(2 * len(nums)):
            temp = id % n

            while callstack.__len__() > 0 and nums[temp] > nums[callstack[-1]]:
                st = callstack.pop()
                out[st] = nums[temp]

            callstack.append(temp)
        return out



