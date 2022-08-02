#503. Next Greater Element II
"""
Time Complexity : O(n)
Space Complexity : O(n) #stack
"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1]*len(nums)
        st = []
        st.append(0)
        
        #pass 1
        for i in range(1, len(nums)):
            while len(st) != 0 and nums[i] > nums[st[-1]]:
                idx = st.pop()
                result[idx] = nums[i]
                
            
            st.append(i)
            
        print(st)
        
        #pass 2 for remaining elements
        if len(st) != 0:
            for i in range(0, len(nums)):
                while len(st) != 0 and nums[i] > nums[st[-1]]:
                    idx = st.pop()
                    result[idx] = nums[i]
                
            
                st.append(i)
                
        return result
        
        
