class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # Initializing variables
        temp = temperatures
        n = len(temp)
        answer = [0] * n  # Creating answer array with zeros
        stack = []  # Using stack to keep track of indices and temperatures

        # Iterating through each temperature
        for i, t in enumerate(temp):
            # Checking if current temperature is higher than the temperature at the top of the stack
            while stack and stack[-1][0] < t:
                stack_t, stack_i = stack.pop()
                # Updating answer for the index at the top of the stack
                answer[stack_i] = i - stack_i
            # Pushing current temperature and index onto the stack
            stack.append((t, i))
        # Returning the final answer array
        return answer

# Time Complexity (TC): O(n), where n is the number of temperatures, since each index is pushed and popped at most once.
# Space Complexity (SC): O(n), for the stack and the answer array.