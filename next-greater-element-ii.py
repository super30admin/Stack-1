# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums==None or len(nums)==0: return None
        n=len(nums)
        result=[-1]*n
        stack=[]
        for i in range(2*len(nums)):
            k=i%n
            # if incomming and top of stack elements are same we can stop the iterations
            if len(stack)!=0 and stack[len(stack)-1]==k:
                return result
            while len(stack)!=0 and nums[stack[len(stack)-1]]<nums[k]:
                cur=stack.pop()
                result[cur]=nums[k]
            if i<n:
                stack.append(i)
        return result
                    