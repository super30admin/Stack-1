#Time complexity is O(4n) from steps 1,2,3
#Space complexity is O(n)
#We use range(0,2n) to achieve circular condition and take modulo for i, so for the second iteration it is i and not n+i
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        mono_stack=[]
        n=len(nums)
        output=[-1 for i in range(n)] #O(n)-> 1
        for i in range(0, 2*n): #O(2n)->2
            i=i%n
            while(mono_stack and nums[mono_stack[-1]]<nums[i]): #O(n)->3
                if i==mono_stack[-1]:
                    break
                output[mono_stack[-1]]=nums[i]
                mono_stack.pop()
            mono_stack.append(i)
        return output 