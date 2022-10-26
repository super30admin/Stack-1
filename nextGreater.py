#Time: O(4n) = O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        st = []
        for i in range(2*n):
            while (st and nums[st[-1]] < nums[i%n]):
                tmp = st.pop()
                result[tmp] = nums[i%n]
            if i < n:
                st.append(i)
            if i >= n and st[-1] == i%n:
                break
        return result
        