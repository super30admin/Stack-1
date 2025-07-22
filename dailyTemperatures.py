# TimeComplexity:O(n)
# SpaceComplexity:O(n)
# Approach:Rather than finding for each ele try to find ele greather than prev ele then go back 


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        """
        find next warmer/ greater day
        for i..in range(len(temps)):
            for j in range(i,len(temps)):
                if temp[j]>temp[i]:
                    add to ans
                    break
                
            [79,74,73,75,69,72,76,73]

        """
        st=[0]
        #fill result array with -1
        result=[0 for _ in range(len(temperatures))]
        for i in range(1,len(temperatures)):
            
            #go back and check
            while(len(st) and temperatures[st[-1]]<temperatures[i]):
                # if temperatures[i]==76:
                #     print(temperatures[st[-1]])
                result[st[-1]]=i-st[-1]
                st.pop()
            #if curr ele is smaller than recent ele
            st.append(i)
           
        return result
