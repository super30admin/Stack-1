#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(N) where N is number of elemtns stored
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        finalArray = [0 for i in range(len(T))]
        n = len(T)
        stack = []

        for index in range(n):
            while (len(stack) > 0 and T[index] > T[stack[-1]]):
                priorIndex = stack.pop()
                finalArray[priorIndex] = index - priorIndex

            stack.append(index)
  
        return finalArray 