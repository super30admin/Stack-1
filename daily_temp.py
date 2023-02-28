# Time Complexity :
# O (N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We store a monotonically increasing stack. 
#we go through each element
#Every time we come across an element greater than the top element of the stack, then we keep popping the elements until a greater element is found and at the popper index, we can store the difference between current index and popper index
# After the above process, we add the current element to the stack

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        stack = collections.deque()
        result = [0] * len(temperatures)

        for i,temp in enumerate(temperatures):
            while len(stack) != 0 and temp > temperatures[stack[-1]] :
                old_index = stack.pop()
                result[old_index] = i - old_index

            stack.append(i)

        return result
