#Time Complexity : O(2n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = [0]
        result = [0] * len(T)

        for i in range(1, len(T)):
            #while stack is not empty and current day temparature is warmer than the temperature at index at the top of the stack
            while stack and T[i] > T[stack[-1]]:
                prev = stack.pop()
                result[prev] = i - prev
            stack.append(i)

        return result
