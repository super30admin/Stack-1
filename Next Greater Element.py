# // Time Complexity : O(N^2)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Brute Force Approach
class Solution:
    def nextGreaterElements(self, nums):
        dn = nums + nums  # create a list doubling nums
        res = [-1] * len(nums)

        # iterate through the nums
        for i in range(len(nums)):
            # iterate through the doubled nums
            for j in range(i+1, len(dn)):
                if dn[j] > dn[i]:  # compare the nums from nums and doubled nums
                    res[i] = dn[j]  # add the greater element from doubled nums list in res using nums index
                    break
        return res
