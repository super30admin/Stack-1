# Time Complexity: O(n) n is the size of the array
# Space Complexity: O(1)
# Approach: Use a monotonic stack.
#			Iterate the array.
#				While the top of the stack is lesser than i calculate index difference and store answer in the input array.
#				Add value to stack
#			If Stack is not empty, for all indexes in stack, make its value in input array as 0.
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = [0]
        for idx,i in enumerate(T[1:],1):
            while len(stack) > 0 and i >T[stack[-1]]:
                val = stack.pop()
                T[val] = idx - val
            stack.append(idx)
            
        while len(stack) != 0:
            val = stack.pop()
            T[val] = 0
        return T