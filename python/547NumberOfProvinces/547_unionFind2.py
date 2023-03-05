class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        UF = {}
        def find(x:int)->int:
            UF.setdefault(x,x)
            if x!=UF[x]:
                UF[x] = find(UF[x])
            return UF[x]
        def union(x,y):
            UF.setdefault(x,x)
            UF.setdefault(y,y)
            UF[find(x)]=find(y)

        for i in range(n):
            for j in range(i+1,n):
                if isConnected[i][j]:
                    union(i,j)
        for i in range(n):
            find(i)
        return len(set(UF.values()))
