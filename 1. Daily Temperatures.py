class Solution:
    def dailyTemperatures(self, temperatures):
        # Time Complexity - O(n)
        # Space Complexity - O(n)

        result = [0] * len(temperatures)
        stack = []

        for i, temp in enumerate(temperatures):
            # While the stack is not empty and the current temp is greater than the top of the stack
            while stack and temp > stack[-1][0]:
                t, idx = stack.pop()
                # Store the result at the appropriate index
                result[idx] = i - idx
            stack.append([temp, i])
        return result