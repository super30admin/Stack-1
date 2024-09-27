#Leetcode : pass
#TC- O(n) SP-O(1)
#1)create result array with 0
#2)push each elem index into stack
#3)check while stack !=Null and stack_top < curr
##3.1)store diff between indices
class Solution:
    def dailyTemperatures(self, T):
        #1
        result = [0]*len(T)
        stack = []
        for index in range(len(T)):
            #3
            while len(stack) != 0 and T[stack[-1]] < T[index]:
                i = stack.pop()
                #3.1
                result[i] = index-i
            #2
            stack.append(index)
        return result


obj = Solution()
print(dailyTemperatures([73,74,75,71,69,72,76,73]))
