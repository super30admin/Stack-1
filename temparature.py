#time complexity:O(n)
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
        res=[0]*len(T)
        stack=[]
        for i in range(len(T)):
            curr=T[i]
            while(len(stack)!=0 and curr > T[stack[len(stack)-1]]):
                res[stack[len(stack)-1]]=i-stack[len(stack)-1]
                stack.pop(len(stack)-1)
            stack.append(i)
        return res