'''
// Time Complexity :
# Problem 1 - O(n) ~ O(2n) n - temperatures in the array
# Problem 2 - O(n) ~ O(2n) n - no. of elements in the array
// Space Complexity :
# Problem 1 - O(n) 
# Problem 2 - O(n)
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Daily Temperatures
# Initialize a result array of length of the temperatures array and an empty stack
# Iterate over the temperatures and append the temperatures inside the stack
# While the stack is not empty and the current temperature is greater than the popped temperature pop 
# out all the temperatures and update the result array with current index and popped element index as it
# represents the number of days
# Return the result array

class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        st = []
        result = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures)):
            curr = temperatures[i]
            while len(st) > 0 and curr > temperatures[st[-1]]:
                popped = st.pop()
                result[popped] = i - popped
            st.append(i)
        return result

## Problem 2 - Next Greater Element II
# Initialize an empty stack and an result array of '-1' of length of the nums array
# Iterate over the range of elements and continue until the array differences stop increasing or 
# decreasing
# When stack is not empty or current element is greater than top element in the stack update the 
# result array with the nums array element
# Return the result array with the greater elements from its neighbors

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        st = []
        n = len(nums)
        result = [-1 for i in range(n)]
        for i in range(2*n):
            idx = i % n
            while len(st) > 0 and nums[idx] > nums[st[-1]]:
                poppedIdx = st.pop()
                result[poppedIdx] = nums[idx]
            st.append(idx)
        return result