# TC : O(N)
# SC : O(N)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        list1 = [-1] * n
        st = []
        st.append(0)
        
        for i in range(1, 2*n):
            while st and nums[st[-1]] < nums[i%n]:
                val = st.pop()
                list1[val] = nums[i%n]
            st.append(i%n)
        return list1