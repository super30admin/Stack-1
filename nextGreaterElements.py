class Solution:
    # monotonic increasing stack
    # TC : O(n)
    # SC: O(n)
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        n = len(nums)
        res = [-1]*len(nums)
        st = []
        for i in range(2*n):
            # 2 times len of array as we need to iterate nums twice. and for idx after n check as i%n 
            while len(st) > 0 and nums[i%n] > nums[st[-1]]:
                popv = st.pop()
                res[popv] = nums[i%n]
            if i < n:
                st.append(i)
        return res

        