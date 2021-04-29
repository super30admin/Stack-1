#Time Complexity=O(n)
#Space Complexity=O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums or len(nums)==0:
            return []
        n=len(nums)
        output=[-1 for i in range(n)]
        stack=deque()
        for i in range(2*n):
            current=nums[i%n]
            while stack and current>nums[stack[-1]]:
                index=stack.pop()
                output[index]=current
            if output[i%n]== -1:
                stack.append(i%n)
        
        return output
            
        
        
