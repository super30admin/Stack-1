'''
Solution:
1.  Use a montonic stack for this problem, where from bottom to top of the stack, you have 
    elements in ascending order.
2.  Push all elements into the stack one-by-one. But, before pushing an element, pop all elements 
    that are lesser to the current element and save the current element's count from popped element's
    location and put it in that location in resultant array.
3.  If any elements are still remaining in the stack => their corresponding location's value is 0.

Time Complexity:    O(N)    |   Space Complexity:   O(N)

--- Passed all testcases successfully on leetcode.
'''


class DailyTemp:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        #   initializations
        finalArray = [0 for i in range(len(T))]
        n = len(T)
        stack = []
        
        #   iterate through the entire array
        for index in range(n):
            
            #   until the condition satisfies => pop and place difference in positions
            #   in resultant array before pushing the current element
            while (len(stack) > 0 and T[index] > T[stack[-1]]):
                priorIndex = stack.pop()
                finalArray[priorIndex] = index - priorIndex
                
            stack.append(index)
        
        #   return final resultant array.    
        return finalArray