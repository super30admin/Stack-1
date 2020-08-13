class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T==None or len(T)==0:
            return []
        stack1=[]
        result= [0]*len(T)
        for i in range(len(T)):
            while len(stack1)!=0 and T[i]>T[stack1[-1]]:
                idx=stack1.pop()
                #resolve the top element in stack
                result[idx]=i-idx
            stack1.append(i)
        return result
    
    
#time is O(2n) every element could be visited twice
#Space is O(n) worst case all in one stack
