class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1] * len(nums)
        st = []
        
        for i in range(2*len(nums)): #to cater for circular nature of list
            
            j = i % len(nums) 
            if not st:
                st.append(j)
            
            else:
                while st and nums[j] > nums[st[-1]]: #pop and process all the elements in the stack that are lesser than the current value
                    idx = st.pop()
                    res[idx] = nums[j] #store the element in res
                    
                st.append(j)
                
        return res