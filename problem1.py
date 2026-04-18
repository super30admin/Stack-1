# problem 1 

# https://leetcode.com/problems/daily-temperatures/

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        my_stack = []
        n = len(temperatures)
        final_arr = [0]*n
        for i in range(n):
            while my_stack and temperatures[i] > temperatures[my_stack[-1]]:
                popped_idx = my_stack.pop()
                final_arr[popped_idx] = i-popped_idx
            my_stack.append(i)
        return (final_arr)
