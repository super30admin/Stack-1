"""
    // Time Complexity :O(2n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    check the T[i] with the top of the stack. if T[i] > stack peek it means resolved
    update the result

    if above condition is false,push the indexes into the stack untill
"""
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        # edge
        if T is None or len(T) == 0 : return [0]

        result = [0 for i in range(len(T))]
        stack = []

        for i in range(len(T)):
            while len(stack) != 0 and T[i] > T[stack[-1]]:
                idx = stack.pop()
                result[idx] = i - idx
            stack.append(i)
        return result
