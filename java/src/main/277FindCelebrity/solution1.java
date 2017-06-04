
olean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // brute force
        int counter;
        for(int i = 0; i < n; i++){
            counter = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }else if( knows(i,j)){
                    break;
                }else if(knows(j,i)){
                    counter++;
                }
            }
            if(counter == n-1){
                return i;
            }
        }
        return -1;
    }
}
