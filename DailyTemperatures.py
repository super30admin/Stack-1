# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack for this approach. Initialize a res array of length T with 0
# Iterate over the T
# Until stack is not empty and top of stack is less than current element we will pop the stack
# Then current element index - stack index will be stored in res
# For each element, append the index to stack
# Return res


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return None
        res = [0] * len(T)
        stack = []
        for i in range(len(T)):
            while stack and T[stack[-1]] < T[i]:
                index = stack.pop()
                res[index] = i - index
            stack.append(i)
        return res
