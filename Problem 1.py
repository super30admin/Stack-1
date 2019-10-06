# Time Complexity : O(n^2) where n is length of T
# Space Complexity :O(n) where n is length of T
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        # stack for storing the temperatures and the index
        stack = []
        # ans list to store the answer
        ans = [0] * len(T)

        # starting from the end we will go to the start
        for i in range(len(T) - 1, -1, -1):
            # while we have got the next highest temperature, we will pop ot from the stack
            while (stack and stack[0][1] <= T[i]):
                stack.pop(0)
            # if there is any such temperature then insert (index of that temp - present index) in the answer else let it remain to 0
            if stack:
                ans[i] = stack[0][0] - i
            # insert the present temperture in the stack
            stack.insert(0, [i, T[i]])

        return ans
