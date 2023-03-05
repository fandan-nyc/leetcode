class UnionFind():
    def __init__(self, n:int):
        self.parents = [i for i in range(n)]
    def find(self, x:int) -> int:
        while x!=self.parents[x]:
            self.parents[x]=self.parents[self.parents[x]]
            x = self.parents[x]
        return x
    def union(self, x:int, y:int):
        if x == y:
            return
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX<rootY:
            self.parents[rootY] = rootX
        else:
            self.parents[rootX] = rootY

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        uf = UnionFind(n)
        for i in range(n):
            for j in range(i+1,n):
                if isConnected[i][j]:
                    uf.union(i,j)
        for i in range(n):
            uf.find(i)
        return len(set(uf.parents))
