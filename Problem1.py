## Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        """
        Time Complexity: O(n)
        - Every element is pushed onto the stack exactly once and popped from the stack at most once.
        - Therefore, the inner while loop runs at most `n` times across all iterations of the outer loop.
        - Overall time complexity is linear with respect to the length of `temperatures`.

        Space Complexity: O(n)
        - In the worst case (e.g., temperatures in strictly decreasing order), all indices are pushed onto the stack,
          requiring O(n) auxiliary space.
        - The `res` array also takes O(n) space to store the output.
        """
        n = len(temperatures)
        res = [0] * n
        
        # Monotonic stack storing pairs of [temperature, index].
        # It maintains temperatures in strictly decreasing order.
        stack = []  # (temp, idx)

        for i, t in enumerate(temperatures):
            # If the current temperature is warmer than the temperature at the top of the stack,
            # we have found the next warmer day for the day at the top of the stack.
            while stack and t > stack[-1][0]:
                st, si = stack.pop()
                # Calculate the number of days waited
                res[si] = i - si
            
            # Push current day's temperature and index onto the stack
            stack.append([t, i])

        return res