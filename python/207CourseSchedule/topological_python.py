class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        n = len(prerequisites)
        if n == 0 or n == 1:
            return True
        graph = collections.defaultdict(list)
        indegree = {}
        for i in range(numCourses):
            indegree[i] = 0

        for i in range(n):
            graph[prerequisites[i][1]].append(prerequisites[i][0])
            indegree[prerequisites[i][0]] += 1
        
        queue = [i for i in indegree.keys() if indegree[i]==0]
        while(len(queue)):
            cur = queue.pop(0)
            del indegree[cur]
            for node in graph[cur]:
                indegree[node] -= 1
                if indegree[node] == 0:
                    queue.append(node)

        return len(indegree) == 0
