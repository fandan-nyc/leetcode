class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] data = prepare(numCourses, prerequisites);
        // 0 --> not visited
        // 1 --> in stack
        // 2 --> visited
        int[] status = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(status[i] != 2){
                boolean res = hasCircle(data, i, status);
                if(res){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    private boolean hasCircle(Node[] data, int start, int[] status){
        if(status[start] == 2){
            return false;
        }
        if(status[start] == 1){
            return true;
        }
        status[start] = 1;
        boolean res = false;
        for(int i: data[start].next){
            if(hasCircle(data, i, status)){
                return true;
            }
        }
        status[start] = 2;
        return false;
    }
    
    private Node[] prepare(int numCourses, int[][] prerequisites){
        Node[] data = new Node[numCourses];
        for(int i = 0; i < numCourses; i++){
            data[i] = new Node(i);
        }
        for(int[] i: prerequisites){
            data[i[1]].next.add(i[0]);
        }
        return data;
    }
     
}

class Node {
    public int val;
    public List<Integer> next;
    
    Node(int val){
        this.val = val;
        next = new ArrayList<>();
    }
}
