# Time Complexity : O(3n) , O(2n) for twice iterating through the array as it is circular+ O(n) for stack look up 
#                 = O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def nextGreaterElements(self, nums):
        result = [-1 for _ in range(len(nums))]
        if len(nums) == 0:
            return result 
        n = len(nums)
        stack = []
        for i in range(len(nums)*2):
            while stack and nums[i%n] > nums[stack[-1]]:
                indx = stack.pop()
                result[indx] = nums[i%n]
            
            if i < n:
                stack.append(i)
        return result
    
if __name__ == "__main__":
    s = Solution()
    
    # Test case 1 
    print(s.nextGreaterElements([1,2,1]))