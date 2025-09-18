#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds the Next Greater Element II for each element in a circular array. It iterates twice over the array (2 * n) so each element can "wrap around," using a stack to store indices of elements waiting for their next greater value. When a larger element is found (nums[i % n] > nums[st[-1]]), the stack index is popped and updated in result; if no greater element exists, it remains -1.

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        st = []

        for i in range(2 * n):
            while st and nums[i % n] > nums[st[-1]]:
                popped = st.pop()
                result[popped] = nums[i % n]
            
            if i < n:
                st.append(i)
            elif st and st[-1] == i % n:
                break
        
        return result