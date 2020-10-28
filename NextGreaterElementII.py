class Solution:
    # Solution 1 - Using Stack (store the index in decreasing order of the nums[index] values)
    # Iterate through the nums array 2*N times - to populate all the values in output as circular array
    # Time Complexity - O(N)
    # Space Complexity - O(N)  
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        l = len(nums)
        output = [-1] * l
        stack = []
        for i in range(0, l*2):
            x = i % l
            
            while stack and nums[stack[-1]] < nums[x]:
                top = stack.pop()
                output[top] = nums[x]
                
            if output[x] == -1:
                stack.append(x)
                
        return output
                
        
        