#using monotonic stack
# space: O(n) stack space
# Time: O(n)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack=[]
        n= len(temperatures)
        temp_diff= [0]* n
        for i in range(n):
            while len(stack) != 0 and temperatures[i] > temperatures[stack[-1]]:
                popped= stack.pop()
                temp_diff[popped]= i - popped
            stack.append(i)
        return temp_diff
