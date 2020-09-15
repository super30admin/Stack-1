#Problem 1:https://leetcode.com/problems/daily-temperatures/
#Test Cases passed on Leetcode 
#Time Complexity:    O(N)
#Space Complexity:   O(N)

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        #Approach:
        #a. Push the index of the  element in the stack if 
            #1.stack is empty
            #2.element is less than or equal to the top element on that index
        #b.If the element is greater than top element on that index, then pop element index till the element smaller than top
         # element at that index or stack is empty
            if not T or len(T)==0:
                return [0]
            result=[0 for i in range(len(T))]
            stack=[]
            for i in range(len(T)):
                while len(stack)>0 and T[i]>T[stack[-1]]:
                    idx=stack.pop()
                    result[idx]=i-idx
                stack.append(i)
            return result
