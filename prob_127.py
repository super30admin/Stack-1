#leetcode 739
#Algo for every elemnt appended to a stack and checked if its next value is greater else keep appending elements to stack
#when ever greater element is found, we pop the lesser temp in stack and now add the temp to be found
#time - O(n)

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack, result = [], [0 for i in range(len(T))]
        for i in range(len(T)):
            while len(stack) and T[stack[-1]] < T[i]:
                idx = stack.pop() #getting index
                result[idx] = i - idx
            stack.append(i) #save index in stack
        return result


class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        res = [0 for i in range(len(T))]
        stack = [0]
        i = 1

        while stack and i < len(T):
            while stack and T[i] > T[stack[-1]]:
                # print(stack)
                res[stack[-1]] = i - stack[-1]
                stack.pop()
            stack.append(i)
            i += 1
        return res
#brtute force - did not pass through leetcode -- time out error

class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        res = [0 for i in range(len(T))]
        sum_temp = 0
        for i in range(len(T)):
            for j in range(i + 1, len(T), 1):
                if T[i] < T[j]:
                    res[i] = sum_temp + 1
                    sum_temp = 0
                    break;
                else:
                    sum_temp += 1
            sum_temp = 0
            # if j == len(T)-1:
            #    print("llll")
            #    res[i] = sum_temp
        return res
