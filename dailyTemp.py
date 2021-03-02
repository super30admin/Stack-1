
#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        res = [0] * len(T)
        for i, t in enumerate(T):
            while len(stack) > 0 and t > stack[-1][0]:
                _, j = stack.pop()
                res[j] = i - j
            stack.append((t,i))
        return res