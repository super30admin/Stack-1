# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I traverse through the array and put each element index in a stack. If current element is greater than the top element in the stack then this is the result 
# for the element at the stack top index. I do this for all the elements. The result for rest of the elements is 0


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        length=len(T)
        stack = []
        result = [0 for x in range(len(T))]
        for i in range(length):
            while len(stack)>0 and T[i] > T[stack[-1]]:
                idx = stack.pop()
                result[idx] = i - idx
                
            if i < length:
                stack.append(i)
                
        return result
