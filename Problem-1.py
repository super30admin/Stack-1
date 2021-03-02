#Time Complexity :o(n)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        if(T==None or len(T)==0):
            return []
        
        res=[0]*(len(T))
        stack=[]
        for i in range(len(T)):
            while(stack and T[i]>T[stack[len(stack)-1]]):
                ind=stack.pop()
                res[ind]=i-ind
            stack.append(i)
        return res
                
        