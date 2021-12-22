#Time, space O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        res=[-1]*len(nums)
        stack=[]
        n=len(nums)
        #Appending into stack until we find the next greater number, then appending the greater value to answer array and popping the previous value and appending the new value
        for i in range(n*2):
            while stack and (nums[stack[-1]]<nums[i%n]):
                res[stack[-1]]=nums[i%n]
                stack.pop()
            stack.append(i%n)   
        return res
