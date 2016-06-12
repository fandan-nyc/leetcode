public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null){
            return false;
        }
        int node = 0;
        int nul = 0;
        String[] input = preorder.split(",");
        for(int i = input.length-1; i>=0; i--){
            if(input[i].equals("#")){
                ++nul;
            }else{
                ++node;
            }
            if(nul - node < 1){
                return false;
            }
        }
        return nul-node == 1;
    }
}
