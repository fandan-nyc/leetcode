class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        ans = []
        outdegree = {}
        ingraph = defaultdict(list)
        for i in range(len(graph)):
            outdegree[i]=0
        for i in range(len(graph)):
            for node in graph[i]:
                ingraph[node].append(i)
                outdegree[i] += 1
        queue = [i for i in outdegree.keys() if outdegree[i] == 0]
        while queue:
            cur = queue.pop(0)
            ans.append(cur)
            del outdegree[cur]
            for node in ingraph[cur]:
                outdegree[node] -= 1
                if outdegree[node] == 0:
                    queue.append(node)
        ans.sort()
        return ans
