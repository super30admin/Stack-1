class Solution:
    
    """
    Description: From a list of temperatures, how many days to wait until warmer day (return an array)
    
    Time Complexity: O(n) {exact: O(2n)}
    Space Complexity: O(n)
    
    Approach: Use Stack
    1. start with a result array with all 0 and an stack
    2. update the stack with indices and find if the next index value from T is better than current
    3. if yes to #2 then update the result array by deducting current and index from #2
    4. continue under a for loop 
    """
    
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        if len(T) == 0 or T == None: return
        
        stack = []; result = [0]*len(T)

        for i in range(len(T)):
            while len(stack) != 0 and T[stack[-1]] < T[i]:
                idx = stack.pop()
                result[idx] = i - idx
            stack.append(i)
                
        return result
