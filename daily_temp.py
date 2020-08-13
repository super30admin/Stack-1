# Time Complexity : O(2n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a stack, if current element > peak element, update the result, and pop the stack since the lement would be resolved

2. If curr element is not > peek element than, it won't be able to resolve any other element in the stack, so move forward

3 As you move foward keep pushing the index on to stack
'''

from collections import deque
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        if not T or len(T) < 1:
            return 
        
        stack = deque()
        result = [0]*len(T)
        for i in range(len(T)):
                   
            while len(stack) > 0:
                peek_ind = stack[-1]
                if T[i] > T[peek_ind]:
                    result[peek_ind] = i - peek_ind
                    stack.pop()
                else:
                    break
            
            stack.append(i)
            
        return result
                
                
                
            