#TC:O(N) SC:O(1)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures==None or len(temperatures)==0:
            return [] 

        stack=[]
        result=[]
        for i in range(len(temperatures)):
            result.append(0)

        for i in range(len(temperatures)):
           
            if len(stack)==0:
                stack.append(i)
            elif temperatures[i]>temperatures[stack[len(stack)-1]]:
                while len(stack)!=0 and temperatures[i]>temperatures[stack[len(stack)-1]]:
                    print(temperatures[i],temperatures[stack[len(stack)-1]],len(stack))
                    poppedIndex=stack.pop()
                    result[poppedIndex]=i-poppedIndex
                stack.append(i)
            else:
                stack.append(i)

        return result        

            
