#using monotonic stack
# space: O(n) stack space
# Time: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        if len(nums) == 0:
            return 
        if len(nums) == 1:
            return [-1]
        n= len(nums)
        s= [0]
        final=[-1] * n
        for i in range(1,2*n):
            idx= i %n
            while len(s) != 0 and nums[idx] > nums[s[-1]] :
                final[s.pop()]= nums[idx]
            s.append(idx)
        return final
