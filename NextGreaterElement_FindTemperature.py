------------------------Daily Temperatures--------------------------------------------

# Time Complexity : O(2N) as N is the length of elements
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we will use stack, to store the elements of the array, we will append to the stack, when the top of the stack
#is less than the current element, I will update the stack.top index of resultant array  with current element index-stack.top. 
# ThenI will append the current element into the stack.

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return []
        
        stack = []
        res = [0]*len(T)
        stack.append(0)
        j = 1
        while j<len(T):
            while stack and T[j]>T[stack[-1]]:
                temp = stack.pop()
                res[temp] = j-temp
            
            stack.append(j)
            j +=1
        return res
        
------------------------Next greater elements--------------------------------------------

# Time Complexity : O(3N) as N is the length of elements we can take 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I will use stack to store the previous elements and iterate through array twice. When I reach end of the array,
# I will circle back by taking the mod of the index and check for the element which is greater then the current element
# if j is less than length of array  I need to append the index to stack , else I will just increase j.
        
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        
        stack = []
        res = [-1]*len(nums)
        stack.append(0)
        j = 1
        n = len(nums)
        while j<2*n:
            while stack and nums[j%n]>nums[stack[-1]]:
                temp = stack.pop()
                res[temp] = nums[j%n]
            if j<n:
                stack.append(j)
            j +=1
        return res