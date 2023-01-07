'''
We can make use of stack here
Time Complexity --> O(n) for time
Space Complexity --> O(n) for stack
'''
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1 for x in range(len(nums))]
        stk = []
        n = len(nums)
        for i in range(2*len(nums)):
            i = i%n
            if len(stk)==0:
                stk.append(i)
            else:
                while len(stk)!=0 and nums[i]>nums[stk[-1]]:
                    res[stk[-1]] = nums[i]
                    stk.pop(-1)
                stk.append(i)
        return res



