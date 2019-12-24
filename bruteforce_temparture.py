#time complexity:O(n^2)
#space complexity:O(n)
#leetcode:accepted
#no doubts
#explination:
#brute force method: two for loops and check if there is any element that is greaater than the current element

#you are creating a stack and keep pushing the index and run the loop if the stack is non empty and check if the current element is greater than the peek elements of the stack. If the current element is greater than the peek element of the stack, we update the result with the

class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        result = [0] * len(T)
        for i in range(len(T)):
            for j in range(i + 1, lenprint(i, j)
            if T[i] < T[j]:
                result[i] = j - i
            break
        return result