# TimeComplexity:O(n)
# SpaceComplexity:O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        """
        largerst ele will always be -1
        can go in curcular manner 
        also should traverse 2x times
        BF:
         FOR.. i..range
            for j in range i,len
                break if nums[j]>nums[i]
        but do we need go for each ele
         lets say we have [5,4,3,2,100]
         we alway break at 100
         if i can aclaculate for recent ele and prev ele 


        """
        st=[0]
        n=len(nums)
        result=[-1 for i in range(len(nums))]
        for i in range(1,len(nums)*2):
            while(len(st) and nums[st[-1]]<nums[i%n]):
                result[st[-1]]=nums[i%n]
                st.pop()
            if result[i%n]==-1:
                st.append(i%n)
        return result

        
