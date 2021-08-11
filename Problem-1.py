from collections import deque
class Solution:
    """
    Approach: Using stack
    In the brute force approach, you'd use a nested for loop and check certain elements twice. We can use a stack to avoid that repetition
    1) put elements in the stack
    2) if you come across a greater element, just get the difference of indices and update the resultant list
        a) note that one greater element can resolve multiple elements in the stack, so keep popping until the current element cannot resolve the top element of the stack
    TC: O(3n)
    SC: O(n)
    """
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0]*n # O(n)
        stack = deque()
        stack.append(0)
        for i in range(1, n): #O(2n)
            while stack and temperatures[i] > temperatures[stack[-1]]:
                top = stack.pop()
                result[top] = i - top
            
            stack.append(i)
        
        
        return result