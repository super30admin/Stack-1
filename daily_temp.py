#Time -> O(n)
#Space -> O(n)

class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        
        #Make an empty list of 0's
        res=[0]*len(t)
        stack=[]
            
        #Iterate through the elemnts
        for i in range(len(t)):
            #While the top of the stack is less than the current elemnt 
            #pop the elemnt and populate the index accordingly
            while stack and t[i]>t[stack[-1]]:
                ind=stack.pop()
                res[ind]=i-ind
            
            #Append to the stack
            stack.append(i)
            
        return res