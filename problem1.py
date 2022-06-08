#Problem1 Daily Temperatures 
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack=[]
        res= [0]*(len(temperatures))
        for i in range(len(temperatures)):
            while(len(stack)!=0 and temperatures[i]>temperatures[stack[-1]]):           #while the current temperature is higher that the one thats on top of the stack, then pop it and put the difference into the array of the popped index
                top = stack.pop()
                res[top] = i - top
            stack.append(i)                                                             #if the current temperature is smaller, then just keep putting the index into the stack
            
        return res
        