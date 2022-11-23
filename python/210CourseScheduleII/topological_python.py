class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        ans = []
        graph = collections.defaultdict(list)
        indegree = {}
        for i in range(numCourses):
            indegree[i] = 0
        
        for i in range(len(prerequisites)):
            graph[prerequisites[i][1]].append(prerequisites[i][0])
            indegree[prerequisites[i][0]] += 1
        
        queue = [i for i in indegree.keys() if indegree[i] == 0]
        while queue:
            cur = queue.pop(0)
            ans.append(cur)
            del indegree[cur]
            for node in graph[cur]:
                indegree[node] -= 1
                if indegree[node] == 0:
                    queue.append(node)

        return ans if len(indegree) == 0 else []
        

        
