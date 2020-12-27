# time - O(2n) - we are revisiting the each node twice - push and pop
# O(n) - stack
# des- enter each index of list into the stack, pop it if there is a breach(if an value is lesser than the one inside the stack) otherwise add that element.
# trick - if there are more than 2 indices inside the stack then the element that is compared with the popped index vlaue must also be compared with second popped index vlaue- because the second popped element is greater that the first popped element and there is no point comparing with elements before the comparing element.

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return [0]

        res = [0] * len(T)
        stack = []
        for i in range(len(T)):
            while stack and T[stack[len(stack) - 1]] < T[i]:
                pop = stack.pop()
                res[pop] = i - pop
            stack.append(i)
        return res