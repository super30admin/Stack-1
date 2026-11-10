# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack for this approach. Initialize a result array of length of temperatures with 0
# Iterate over the temperatures array
# Until stack is not empty and top of stack is less than current element we will pop the stack
# Then current element index - stack index will be stored in res
# For each element, append the index to stack
# Return res

class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        stack = []
        n = len(temperatures)
        result = [0] * n
        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                popped = stack.pop()
                result[popped] = i - popped
            stack.append(i)
        return result
