#Leetcode : pass
#TC- O(n) SP-O(1)
#1)create result array with -1
#2)push each elem index into stack
#3)loop over the array twice as it's circular array
#4)check while stack !=Null and stack_top < curr
##4.1)store curr elem

class Solution:
    def nextGreaterElements(self, nums):
        #1
        result = [-1]*len(nums)
        stack =[]
        #3
        for x in range(len(nums)*2):
            i = x%len(nums)
            #4
            while len(stack) != 0 and nums[i] > nums[stack[-1]]:
                #4.1
                result[stack.pop()] = nums[i]
            #2    
            stack.append(i)
        return result

obj = Solution()
print(dailyTemperatures([1,2,1]))
