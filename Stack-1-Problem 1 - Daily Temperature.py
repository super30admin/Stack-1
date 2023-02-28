 """
FAANMG Problem #131 {Medium} 

739. Daily Temperatures

# Time Complexity = O(n)
# Space Complexity = O(n)


Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar
"""


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        stack = []
        n = len(temperatures)
        
        result = [0]*n
        # loop through each temperature in the input array
        for idx in range(n):
             # while the stack is not empty and the current temperature is greater than the temperature at the top of the stack
            while stack and temperatures[idx] > temperatures[stack[-1]]:
                
                # pop the index of the temperature at the top of the stack
                j = stack.pop()
                
                # calculate the number of days between the current index and the index at the top of the stack
                result[j] = idx - j
             # push the current index onto the stack   
            stack.append(idx)
            
        return result
        