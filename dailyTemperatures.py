'''
Funda: Use monotomic stack concept
Time Complexity: 0(n) [Iterate the temperature array] + 0(n) [Iterate the stack (Worst Case)]
Space Complexity: 0(n) [Stack]
Run on leetcode: Yes
'''

class Solution:
    
    def __init__(self):
        self.__stack = []
    
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # initialize answers list
        answers = [0]*len(temperatures)
        
        # add default 0th index to the stack
        self.__stack.append(0)
        
        # iterate the temperatures
        i = 1
        while i < len(temperatures):
            # compare the ith value with peek
            
            # currentTemp is greater than the previousTemp
            if temperatures[i] > temperatures[self.__stack[-1]]:
                
                while len(self.__stack) !=0  and temperatures[i] > temperatures[self.__stack[-1]]:
                    # update the answer[PEEK] with the result
                    answers[self.__stack[-1]] = i - self.__stack[-1]
                    # pop the element from the stack
                    self.__stack.pop()
            
            # add the index to the stack
            self.__stack.append(i)
            # update i
            i += 1     
            continue
        '''end of while loop'''
        
        # print the answers
        # print(f"Answers result is:\t {answers}")
        return answers      