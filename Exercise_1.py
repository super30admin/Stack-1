# Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)
# // Time Complexity :O(2N) = O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def dailyTemperatures(self, temperatures):
        if not temperatures:
            return []
        result = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                popped_index = stack.pop()
                result[popped_index] = i - popped_index
            stack.append(i)
        return result


sol = Solution()
print(sol.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
