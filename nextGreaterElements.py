#Time Complexity:O(n)
#Space Complexity:O(n)
#Ran successfully on Leetcode:Yes
#Algo:
#1.Initiate a stack and res array filled with -1 for the length of nums.
#2.Run the for loop for 2n length. 
#3.The stack stores the indices of the elements from the nums. The top of the stack refers to the index of the next greater element found so far. 
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        res=[-1]*n
        stack=[]
        
        for i in range(2*len(nums)):
            while stack and nums[i%n]>nums[stack[-1]]:
                idx=stack.pop()
                res[idx]=nums[i%n]
            if i <n:
                stack.append(i)
        return res
