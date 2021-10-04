"""
Time Complexity : O(n) where n is the no. of days temperature recorded
Space Complexity : O(n) where n is the no. of days temperature recorded
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if len(temperatures) == 0:
            return []
        stack = []
        # Resulting array to store the no. of days to wait
        result = [0]*len(temperatures)
        # We traverse through the temperatures array and for every day we push the 
        # temoerature index into the stack until we find the warmer day and calculate 
        # the index by subtracting current day index and the index on top of stack at
        # which we found a warmer temperature
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        return result