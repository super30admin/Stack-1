class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]: 
        if not nums or len(nums)==0:
            return nums
        output=[-1 for i in range(len(nums))]
        
        stack=[]
        for i in range(len(nums)*2):
            index=i%len(nums)
            
            while stack and nums[stack[-1]]<nums[index]:
                output[stack.pop()]=nums[index]
            
            if output[index]==-1:
                stack.append(index)
            
        return output
        
        