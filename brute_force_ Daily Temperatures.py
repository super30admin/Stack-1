#time: O(n^2)
#sspace: O(1)

#Brute force 
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if(T==None or len(T)==0):
            return []
        
        result=[]
        
        for i in range(len(T)):
            k=i
            for j in range(i+1,len(T)):
                if(T[i]<T[j]):
                    k=j
                    break
            result.append(k-i)
        return result
            
        