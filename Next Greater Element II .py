
# Stack approach        (storing -- unresolved elements in stack)
# time : O(2N), we will loop through the array twice 
# space : O(1)
# run on leetcode : yes

class Solution:
    def nextGreaterElements1(self, nums):

        # EDGE CASE
        result = [-1] * len(nums)
        if nums == [] or len(nums) == 0:
            return result
        
        st = [0]
        for i in range(len(nums)):
            while st != [] and nums[i] > nums[st[-1]]:
                idx = st.pop()
                result[idx] = nums[i]
            st.append(i)

        for j in range(len(nums)):
            if idx != j and nums[j] > nums[st[-1]]:
                idx = st.pop()
                result[idx] = nums[j]
        return result
        

# =======================================================================

    def nextGreaterElements2(self, nums):
        
        # EDGE CASE
        result = [-1] * len(nums)
        if nums == [] or len(nums) == 0:
            return result
        
        st = [0]
        n = len(nums)
        for i in range(2*n):
            while st != [] and nums[i%n] > nums[st[-1]]:
                idx = st.pop()
                result[idx] = nums[i%n]
            if i < n:
                st.append(i)
                
        return result


obj = Solution()
print(obj.nextGreaterElements1(nums=[1,2,1]))
print(obj.nextGreaterElements2(nums=[1,2,1]))







