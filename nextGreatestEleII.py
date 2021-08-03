class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        """using stack
        Time complexity-O(3n)~O(n)
        Space complexity-O(n)"""
        arr=[-1 for _ in range(len(nums))]
        stack=[]
        for i in range(len(2*nums)):
            while stack and nums[stack[-1]]<nums[i%len(nums)]:
                temp=stack.pop()
                arr[temp]=nums[i%len(nums)]
            stack.append(i%len(nums))
        return arr