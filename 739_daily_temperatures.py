class Solution:
    def dailyTemperatures(self, T):
        """
            https://leetcode.com/problems/daily-temperatures/
            Time Complexity - O(n)
            'n' is the length of the list
            Space Complexity - O(n)
        """
        ans = [0] * len(T)
        stack = []
        for i, t in enumerate(T):
            while stack and T[stack[-1]] < t:
                prev_idx = stack.pop()
                ans[prev_idx] = i - prev_idx
            stack.append(i)
        return ans


if __name__ == '__main__':
    Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73])
