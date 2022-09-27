# Time compplexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # building stack
        st = []
        
        # check for null or emplty array
        if not temperatures or len(temperatures) == 0:
            return []
        
        n = len(temperatures)
        i = 1
        
        # append the first element into the stack
        st.append(0)
        
        # result array to return the number of hot days
        res = [0] * n
        
        while i < n:
            # take top element of the stack
            top = st[-1]
            # if the temperature is lesser than the top of stack, append the index to the stack
            if temperatures[top] >= temperatures[i]:
                st.append(i)
                i += 1
            else:
                # if we encounter a higher temp in the array, pop the stack until we have a higher val
                while st and temperatures[top] < temperatures[i]:
                    top = st.pop()
                    # store the res for popped values
                    res[top] = i - top
                    
                    # update the top after each popped operation
                    if st:
                        top = st[-1]
                # otherwise just append the element in the stack
                st.append(i)
        
        return res
