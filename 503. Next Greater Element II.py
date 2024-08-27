########503. Next Greater Element II#####################################################################################
// Time Complexity : O(n)
// Space Complexity : O(n) -> for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
I used monotonous stack here where I inserted elements in stack and started poping them out when we found element grater than it but here we had to go through the list 2 times as it is mentioned circular


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        stack=[]
        result=[-1]*n
        for i in range(2*n):
            if i>=n:
                i=mod(i,n)
            while len(stack)>0 and nums[i]>stack[-1][1]:
                popelem=stack.pop()
                result[popelem[0]]=nums[i]
            if i<n:
                stack.append([i,nums[i]])
        return result
                
        
        
            
            

        
        
