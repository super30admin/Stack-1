#time: O(n)
#space: O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if(nums==[]):
            return []
        n=len(nums)
        result=[-1]*n
        stack=[]
        for i in range(2*n):
            while(stack!=[] and nums[i%n]>nums[stack[-1]%n]):
                index=stack.pop()
                result[index%n]=nums[i%n]
            if(i < n):
                stack.append(i)
                
                
        return result
                    