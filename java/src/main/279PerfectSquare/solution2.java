public class Solution {

    public int numSquares(int n) {
        int level = 1;
        List<Integer> squares = new ArrayList<>();
        for(int i = 1; i *i <= n; i++){
            squares.add(i*i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int curr = queue.remove();
                for(int i = 0; i < squares.size(); i++){
                    if(curr == squares.get(i)){
                        return level;
                    } else if( curr < squares.get(i)){
                        break;
                    }else{
                        queue.add(curr - squares.get(i));
                    }
                }
                size --;
            }
            level++;
        }
        return -1;
    }
}
