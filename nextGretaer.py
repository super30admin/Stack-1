# As taught in class, using stack to find next greater for each element 
#Time Complexity: O(3n)
#Space Complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums)==0:
            return []
        n = len(nums)
        st = list()
        result = [-1]*len(nums)
        for i in range(0,2*n):
            while len(st)!=0 and nums[i%n] > nums[st[-1]]:
                result[st.pop()] = nums[i%n]
            if i < n:
                st.append(i)
        return result