# Time Complexity : O(n) worst case O(2n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):
            while len(stack) > 0 and temperatures[i] > stack[len(stack)-1][0]:
                lastelement = stack[len(stack)-1]
                result[lastelement[1]] = i - lastelement[1]
                stack.pop()
            stack.append((temperatures[i],i))
        return result