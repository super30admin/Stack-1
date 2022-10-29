#Time -> O(n)
#Space -> O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        res=[-1]*n
        stack=[]

        #Checking the element of the right part of the list
        for i in range(n):
            while stack and nums[stack[-1]]<nums[i]:
                res[stack.pop()]=nums[i]
            
            stack.append(i)

        #Cheking for the left part of the list   
        for i in range(n):
            while stack and nums[stack[-1]]<nums[i]:
                res[stack.pop()]=nums[i]
            
        return res