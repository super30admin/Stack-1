'''
Accepted on leetcode(739)
Time - O(N)
space - O(N) , using stack
Approach:
1. Declare a result array with the size same as the length of given T and also declare stack.
2. iterate over given array and push the indexes into stack.
3. if the stack is not empty and element at current position has greater value than the element exists in top of stack, then, mutate the result array by popping last element from stack and substracting from current index and store in the index position of popped stack element in result array.
'''


class Solution:
    def dailyTemperatures(self, T):
        result = [0 for i in range(len(T))]
        stack = []

        for i in range(len(T)):
            while stack and T[i] > T[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)

        return result