# Time Complexity: O(2n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode :Yes
# Approach: push the elements in stack if found greater than the top of stack , resolve until the condition is met, store in stack

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        #stack initialization
        dq = deque()
        #put dummy values
        res = [0] * len(temperatures)

        for i, val in enumerate(temperatures):
            #if stack is empty
            if not dq:
                dq.append(i)
            #if stack is not empty
            if dq:
                #check the new value is greater than previous
                while dq and temperatures[dq[-1]] < val:
                    # if new is greater store the difference in values until condition is met
                    res[dq[-1]] = i - dq[-1]
                    #pop the resolved item
                    dq.pop()

                #add the current value to stack to be resolved by future item
                dq.append(i)

        return res
