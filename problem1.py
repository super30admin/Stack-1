"""
739. Daily Temperatures
Time Complexity - O(2*n)
Space Complexity - O(n)
Here we are using a stack to store index of numbers and check if value at last element of stack is less than the next temperature whenever this turns true just put difference in output array and pop that index from stack.
"""
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T == None or len(T) == 0:
            return T
        output = [0]*len(T)
        stack = []
        for i in range(len(T)):
            while len(stack) != 0 and T[stack[-1]] < T[i]:
                index = stack.pop()
                output[index] = i - index
            stack.append(i)
        return output