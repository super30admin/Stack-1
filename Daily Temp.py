# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def dailyTemperatures(self, temp):
        n = len(temp)
        ans = [0] * n
        stack = []  # pair [index, temp]

        # tuples of index and temp for easier comparison with temp in stack's top
        # and calculate no.of days
        for i, t in enumerate(temp):
            while stack and t > stack[-1][1]:  # compare current temp to stack's top temp
                stackInd, stackT = stack.pop()
                ans[stackInd] = (i - stackInd)  # calculate no.of days
            stack.append([i, t])
        return ans
