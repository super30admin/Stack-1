#leetcode 503
# Refer leetcode prob 739 and since this is circular we have to iterate through the list for twice, as by iterating it for max by  twice we can find the next higher element
# Inioate the res array with -1
#return elements instead of indices
#time -  O(n) -- 2n
class Solution(object):
    def nextGreaterElements(self, nums):
        stack, result = [], [-1 for i in range(len(nums))]
        j = len(nums)
        for x in range(2*j):
            i= x % j
            while len(stack) and nums[stack[-1]] < nums[i]:
                idx = stack.pop() #getting index
                #if idx < j:
                result[idx] = nums[i]
            stack.append(i) #save index in stack
        return result