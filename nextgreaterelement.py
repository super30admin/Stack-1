class Solution:
    # two rounds through the array and use stack to check the next greatest element similar to Daily temperatures problem
    # TC-O(3n), SC-O(n)
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1 for i in range(len(nums))]
        st=[]
        for i in range(2*len(nums)):
            while(len(st)!=0 and nums[st[-1]]<nums[i%len(nums)]):
                u = st.pop(-1)
                res[u]=nums[i%len(nums)]
            if(i<len(nums)):
                st.append(i)
        return res
            