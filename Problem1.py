class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(N)
        Space: O(N) [Stack as Auxiliary Space]
        
        Passed All Test Cases : Yes
        
        Approach : # Put the temparatures including its index until it encounters any warmer temparature. 
                   # When it encounters a warmer temparature, the program starts to pop from the stack until it gets a greateer or smaller value.
                   # While popping the value, it deducts the popped ones index with current temparature index to get the number of days
                   # At the end, if stack is not empty, it pops everything from stack and assigns those as 0
    
    """
    
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        # edge case
        if not T:
            return []
        
        # initializing stack and output array
        stack = []
        res = [0 for i in range(len(T))]
        
        for i in range(len(T)):
            # if the stack is empty, we just append the curreent temp with its index
            if len(stack) == 0:
                stack.append((T[i], i))
            else:
                # Start popping if the peek value is less than the curreent temparature
                while len(stack) != 0 and stack[-1][0] < T[i]:
                    curr = stack.pop()
                    res[curr[1]] = i - curr[1]
                stack.append((T[i], i))
        
        # pop the rest of the values that is left in stack
        if len(stack) != 0 :
            curr = stack.pop()
            res[curr[1]] = 0
        
        
        return res
