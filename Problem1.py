# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#use stack to keep track of previous un-calculated days
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        tLen = len(temperatures)
        stack = []
        res = [0] * tLen
        for i in range(tLen - 1, -1, -1):
            while stack and temperatures[i] >= temperatures[stack[-1]]:
                stack.pop()
            if stack: res[i] = stack[-1] - i
            stack.append(i)
        return res