class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # Time, Space Complexity: O(n)
        o = [-1 for i in range(0,len(nums))]
        st = []
        for i in range(0,2*len(nums)):
            while((len(st)>0) and nums[i%len(nums)]>nums[st[-1]]):
                idx = st.pop()
                o[idx] = nums[i%len(nums)]
            if(i<len(nums)):
                st.append(i)
        return o
