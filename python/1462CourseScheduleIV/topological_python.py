class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        ans = []
        graph = defaultdict(list)
        indegree = {}
        parent = defaultdict(set)
        for i in range(numCourses):
            indegree[i] = 0
            parent[i].add(i)
        for u, v in prerequisites:
            graph[u].append(v)
            indegree[v] += 1
        queue = [i for i in indegree.keys() if indegree[i] == 0]
        while queue:
            cur = queue.pop(0)
            for node in graph[cur]:
                parent[node] = parent[node].union(parent[cur])
                indegree[node] -= 1
                if indegree[node] == 0:
                    queue.append(node)

        for u, v in queries:
            if u in parent[v]:
                ans.append(True)
            else:
                ans.append(False)

        return ans
