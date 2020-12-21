# Time:- O(n)
# Space:- O(n)
# Approach:- Using a stack to record the temperature when we get a temperature which is greater than what is at the top of stack we will pop from the stack and continue popping(increase counter) until we have nothing in the stack, then we will record this temperature as the latest temperature, if we find a temperature which is lower than what we have at the top of stack we will append to the stack the latest temperature.
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        # store the temperature and the day on which it occured
        temperatures_stack=[[T[0],0]]
        # by default we dont know when a warmer temperature might happen
        res=[0]*len(T)
        for i in range(1,len(T)):
            # if we have something in the stack and temperature we are seeing right now
            # is greater than the temperature which was seen previously
            while temperatures_stack and T[i]>temperatures_stack[-1][0]:
                    res[temperatures_stack[-1][1]]=i-temperatures_stack[-1][1]
                    temperatures_stack.pop()
            # append the latest temperature to the stack along with the day
            temperatures_stack.append([T[i],i])
        return res