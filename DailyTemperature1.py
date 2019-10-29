# Time Complexity: O(n) n is the size of the array
# Space Complexity: O(n)
# Approach: Initialize a result array.
#			Use a monotonic stack.
#			Iterate the array.
#				While the top of the stack is lesser than i calculate index difference and store answer in the result array.
#				Add value to stack
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = [(T[0],0)]
        result = [0]*len(T)
        for idx,i in enumerate(T[1:],1):
            while len(stack) > 0 and i > stack[-1][0]:
                val = stack.pop()
                result[val[1]] = idx - val[1]
            stack.append((i,idx))
            
        return result