#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(N) where N is number of elemtns stored
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        finalArray = [-1 for i in range(len(nums))]
        n = len(nums)
        stack = []
        for index in range(2 * n):
            while (len(stack) > 0 and nums[index % n] > nums[ stack[-1] ]):
                priorIndex = stack.pop()
                finalArray[priorIndex] = nums[index % n]

            stack.append(index % n)
        return finalArray 