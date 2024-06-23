class PackageInstaller():

    def __init__(self):
        pass
    

    def install(self,dependencies):
        n = len(dependencies)
        
        indegree={}
        graph={}
        for node in dependencies:
            if node not in indegree:
                indegree[node]=0
            indegree[node]+=len(dependencies[node])
            for child in dependencies[node]:
                if child not in graph:
                    graph[child]=[]
                graph[child].append(node)
        x =self.topological_sort(graph,indegree)
        return x

        

    def topological_sort(self,graph, indegree):
        if not graph:
            return []
        order =[]
        queue=[]
        for node in indegree:
            if indegree[node]==0:
                queue.append(node)

        while queue:
            node =  queue.pop(0)
            order.append(node)
            #print(order)
            if node in graph:
                for child in graph[node]:
                    indegree[child]-=1
                    if indegree[child]==0:
                        queue.append(child)

        return order

 
if __name__ == '__main__':
    dependencies = {
        0:[1],
        1:[0]
    }

    packageInstaller = PackageInstaller()
    print(packageInstaller.install(dependencies))
