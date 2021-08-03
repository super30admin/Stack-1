# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] *len(temperatures)
        if temperatures == None:
            return result
        stack = []
        for i in range(0,len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                top = stack.pop()
                result[top] = i - top
            stack.append(i)
        return result