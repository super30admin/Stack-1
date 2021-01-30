"""
Intuition

Consider trying to find the next warmer occurrence at T[i]. What information (about T[j] for j > i) must we remember?

Say we are trying to find T[0]. If we remembered T[10] = 50, knowing T[20] = 50 wouldn't help us, as any T[i] that has its next warmer ocurrence at T[20] would have it at T[10] instead. However, T[20] = 100 would help us, since if T[0] were 80, then T[20] might be its next warmest occurrence, while T[10] couldn't.

Thus, we should remember a list of indices representing a strictly increasing list of temperatures. For example, [10, 20, 30] corresponding to temperatures [50, 80, 100]. When we get a new temperature like T[i] = 90, we will have [5, 30] as our list of indices (corresponding to temperatures [90, 100]). The most basic structure that will satisfy our requirements is a stack, where the top of the stack is the first value in the list, and so on.

Algorithm

As in Approach #1, process indices i in descending order. We'll keep a stack of indices such that T[stack[-1]] < T[stack[-2]] < ..., where stack[-1] is the top of the stack, stack[-2] is second from the top, and so on; and where stack[-1] < stack[-2] < ...; and we will maintain this invariant as we process each temperature.

After, it is easy to know the next occurrence of a warmer temperature: it's simply the top index in the stack.

Here is a worked example of the contents of the stack as we work through T = [73, 74, 75, 71, 69, 72, 76, 73] in reverse order, at the end of the loop (after we add T[i]). For clarity, stack only contains indices i, but we will write the value of T[i] beside it in brackets, such as 0 (73).

TC: O(n)
SC: O(n)

n = size of the given array

"""

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T == None or len(T) == 0:
            return []
        
        ans = [0] * len(T)
        stack = [] 
        
        for i in range(len(T)):
            while len(stack) and T[i] > T[stack[-1]]:
                idx = stack.pop()
                ans[idx] = i - idx
            stack.append(i)
            
        return ans