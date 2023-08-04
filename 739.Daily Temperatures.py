# Monotonic decreasing stack type.
# Time complexity = O(2N) [76,75,74,73,72,79]
# In the stack we are storing just the indexes and not the value
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)  # Initialize result list with 0s
        stack = []
        for i in range(len(temperatures)):
            while(len(stack)!=0 and temperatures[i]>temperatures[stack[-1]]): #temperatures[stack[-1]] is equivalent to stack.peek
                popped = stack.pop() # we are getting the last element out of the stack if the current temperature is greater than st[-1]
                result[popped] = i - popped # At the popped index we are putting the difference between the indices
            stack.append(i)
        return result