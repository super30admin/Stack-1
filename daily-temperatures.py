# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        answer = [0] * n
        stack = []  # Stack to store indices of temperatures
        
        for i in range(n):
            # While stack is not empty and current temperature is warmer than the temperature at the top of stack
            while stack and temperatures[i] > temperatures[stack[-1]]:
                # Pop the index from stack and calculate the difference
                prev_index = stack.pop()
                answer[prev_index] = i - prev_index
            
            # Push current index onto stack
            stack.append(i)
        
        return answer
        