"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

"""
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        """
        Using stack and storing the temp in decreasing order. Checing the curr temp with the top of the stack if the temp is higher in the array we will pop the tem from the stack.
        
        TC: O(N)
        SC: O(N)
        """
        t = len(temperatures)
        res = [0 for i in range(t)]
        
        stack = [(0, temperatures[0]),]
        
        for i in range(1, t):
            while  stack and stack[-1][1] < temperatures[i]:
                res[stack[-1][0]] = i - stack[-1][0]
                stack.pop()
                
            stack.append((i, temperatures[i]))
                    
        return res
                    
                    
            
        
        
        