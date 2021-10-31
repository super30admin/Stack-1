# Time Complexity : O(2n) -> O(N) in worst case, next warmer day for first element is the last element
# Space Complexity : O(N) worst case, same reason as time complexity, then all array elements go into stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I forgot that we're putting index and not the 
# temperature into stack, so got stuck there for a bit

# Your code here along with comments explaining your approach

# we use the concept of monotonically increasing/ decreasing stack here
# iterate over array in for loop while stack is not empty and the current temperature
# at index i > element at top of stack(TOS) index
# that means the TOS can be resolved by element at i
# so in result, at index given by TOS, put i - top as i is a later day temperature
# than top 

from collections import deque
class Solution:

    def dailyTemperatures(self, temperatures):

        result = [0] * len(temperatures)
        if temperatures is None or len(temperatures) == 0:
            return result
        
        st = deque()

        for i in range(len(temperatures)):

            while len(st) != 0 and temperatures[i] > temperatures[st[-1]]:

                top = st.pop()
                result[top] = i - top

            st.append(i)
        
        return result
        