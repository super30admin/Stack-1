#Problem2 Next Greater Element II 

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack=[]
        n = len(nums)
        res=[-1]*len(nums)
        
        for i in range(n*2):                                                    #you iterate through the list twice max because its a circular array
            while (len(stack)!=0 and nums[i%n]>nums[stack[-1]]):                #while the current element is greater than the top element of the stack, pop it and add it at the index of the popped element
                top = stack.pop()
                res[top] = nums[i%n]
            if(i<n):                                                            #else, you just add the index to the stack as you havent found anything higher yet
                stack.append(i)
        return res
        

