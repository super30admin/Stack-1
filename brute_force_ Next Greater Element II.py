#time: O(n^2)
#space: O(1)

#brute force
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result=[]
        for i in range(len(nums)):
            flag=True
            j=(i+1)%len(nums)
            while(j!=i):
                if(nums[i]<nums[j]):
                    result.append(nums[j])
                    flag=False
                    break
                j=(j+1)%len(nums)
            if(flag):
                result.append(-1)
                
                
        return result
                    