# APPROACH 1: Stack solution
# Time Complexity : O(n), n: length of T
# Space Complexity : O(n), due to size of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Use stack to put those indices of lower temperature
# 2. If we find a greater temperature than the top of stack, pop if off and write the difference in the indices (curr - stack's top element) -> number of days in it's 
#    corresponding result. 
# 3. Keep resolving this till this new temperature is greater than the top of stack. Then move forward
# 4. At end of array, there will be some unresolved indices in stack. Place 0 in their corressponding result.


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        if len(T) < 1 or T is None or len(T) > 30000:
            return []
        
        stack, result = [], [0 for _ in range(len(T))]
        stack.append(0)
        
        for ind in range(1, len(T)):
            if T[ind] < 30 or T[ind] > 100:
                return []
            else:
                while len(stack) > 0 and T[ind] > T[stack[-1]]:
                    top_ind = stack.pop()
                    result[top_ind] = ind - top_ind
                    
                stack.append(ind)
                
        while stack:
            ind = stack.pop()
            result[ind] = 0
            
        return result
