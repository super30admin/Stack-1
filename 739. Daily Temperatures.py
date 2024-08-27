##########739. Daily Temperatures######################################################################################
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
Here I used monotonous stack where I entered the values in stack and posed them out until the incoming element is greater than element tack top element

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack=[]
        result=[0]*len(temperatures)
        for i,val in enumerate((temperatures)):
            while len(stack)>0 and val>stack[-1][1]:
                popelem=stack.pop()
                result[popelem[0]]=i-popelem[0]
            stack.append([i,val])
        return result
        

        
        
