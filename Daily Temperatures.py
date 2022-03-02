class Solution:
    
    # Using stack
    # TC: O(N) --> 2N --> N is len of array
    # SC: O(N) --> size of stack
    
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        n = len(temperatures)
        
        result = [0 for i in range(n)]
        stack = []
        
        for i in range(n):
            while (len(stack) != 0 and temperatures[i] > temperatures[stack[-1]]):
                popped = stack.pop()
                result[popped] = i - popped
            stack.append(i)
                    
        return result