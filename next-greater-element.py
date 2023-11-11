class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1 for i in range(n)]
        st = []

        for i in range(0,2*n):
            while(len(st) != 0 and nums[st[len(st)-1]] < nums[i % n]):
                popped = st.pop()
                result[popped] = nums[i % n]
            if i<n:
                st.append(i)
        return result
                