# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def dailyTemperatures(self, temperatures):

        stack = []
        result = [0 for i in range(len(temperatures))]
        #         Updating the start element in the temperature
        # Iterating over the array and check untill current value is greater than stack top element and if not just append it to the stack and update the result
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                current_i = stack.pop()
                result[current_i] = i - current_i
            stack.append(i)
        return result

