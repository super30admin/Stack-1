'''
Solution:
1.  Use a montonic stack for this problem, where from bottom to top of the stack, you have 
    elements in ascending order.
2.  Push all elements into the stack one-by-one. But, before pushing an element, pop all elements 
    that are lesser to the current element and save the current element's value and put it in that
    location in resultant array. But make a double traversal since array is circular.
3.  If any elements are still remaining in the stack => their corresponding location's value is -1

Time Complexity:    O(N)    |   Space Complexity:   O(N)

--- Passed all testcases successfully on leetcode.
'''


class NextGreaterElement:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        #   initializations
        finalArray = [-1 for i in range(len(nums))]
        n = len(nums)
        stack = []
        
        #   iterate through the entire array twice
        for index in range(2 * n):
            
            #   until the condition satisfies => pop and place the value in positions
            #   in resultant array before pushing the current element
            while (len(stack) > 0 and nums[index % n] > nums[ stack[-1] ]):
                priorIndex = stack.pop()
                finalArray[priorIndex] = nums[index % n]
                
            stack.append(index % n)
         
        #   return final resultant array.   
        return finalArray