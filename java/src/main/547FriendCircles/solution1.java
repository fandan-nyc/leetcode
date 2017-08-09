public class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length== 0 || M[0].length == 0){
            return 0;
        }
        UnionFind uf = new UnionFind(M);
        int counter = 0;
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < M.length; i++){
            res.add(uf.find(i));
        }
        return res.size();
    }
    
    class UnionFind {
        private int[] store ; 
        
        public UnionFind(int[][] data){
            store = new int[data.length];
            for(int i = 0; i < data.length; i++){
                store[i] = i;
                // self friend
            }
            for(int i = 0; i < data.length; i++){
                for(int j = i+1; j < data.length; j++){
                    if(data[i][j] == 1){
                        union(i, j);
                    }
                }
            }
        }
        
        public int find(int a){
            if(store[a] != a){
                store[a] = find(store[a]);
            }
            return store[a];
        }
        
        private void union(int a, int b){
            int aFind = find(a);
            int bFind = find(b);
            store[aFind] = bFind;
        }
    }
}
