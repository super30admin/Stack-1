# Time Complexity: O (n^2)(Where n is total numbers) 
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : No (Timed out)
# Three line explanation of solution in plain english:
# Brute force solution

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
#       Initialize length of array and anser array.
        ln = len(nums)
        ans = []
        
#       Loop over every element
        for i in range(ln):
            current = nums[i]
#           Initialize next max number for current element
            temp = -1
#           Iterate over current elment index plus 1 to current elment index plus length of given list
            for j in range(i+1, i + ln):
#               calculate current element index by modulo length of given list
                if nums[j%ln] > current:
#                   If number is greater than current break out of loop
                    temp = nums[j%ln]
                    break
#           append temp to the answer
            ans.append(temp)
        
        return ans
