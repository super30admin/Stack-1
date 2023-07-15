# Time Complexity : O(n) because we are iterating through the array
# Space Complexity : O(n) because we are using a stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this approach we are using a stack to store the index of the temperatures array. We are iterating through the temperatures array and checking 
if the current temperature is greater than the temperature at the top of the stack. If it is greater then we pop the top of the stack and calculate 
the difference between the current index and the index at the top of the stack and store it in the answer array. We keep doing this until the current 
temperature is less than the temperature at the top of the stack. Once we are done with this we push the current index into the stack.
"""

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures == None or len(temperatures) == 0: return []

        answer = [0 for i in range(len(temperatures))]
        stack = []

        for i in range(len(temperatures)):
            while len(stack) > 0 and temperatures[i] > temperatures[stack[len(stack) - 1]]:
                top = stack.pop()
                answer[top] = i - top
            stack.append(i)

        return answer
