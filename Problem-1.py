#Approach
# maintain a stack and if incoming element in greater than stack.peek() resolve the stack or else append to the stack.


#Complexities
#Time: O(n)
#Space: O(n)



from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):

            while stack :
                lastElement = stack.pop()
                if lastElement[0] < temperatures[i]:
                    result[lastElement[1]] = i - lastElement[1]
                else:
                    stack.append(lastElement)
                    break
            stack.append((temperatures[i], i))
        return result


