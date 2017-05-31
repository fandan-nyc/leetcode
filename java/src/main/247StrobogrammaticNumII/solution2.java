public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> data = new ArrayList<>();
        helper(data, new char[n], 0, n-1);
        return data;
    }
    
     private void helper(List<String> result, char[] data, int left, int right) {
        if(left > right){
            result.add(new String(data));
            return;
        }
        else if(left == right){
            data[left] = '1'; result.add(new String(data));
            data[left] = '0'; result.add(new String(data));
            data[left] = '8'; result.add(new String(data));
            return;
        }
        else {
            data[left] = '1'; data[right] = '1'; helper(result, data, left+1, right-1);
            data[left] = '8'; data[right] = '8'; helper(result, data, left+1, right-1);
            data[left] = '6'; data[right] = '9'; helper(result, data, left+1, right-1);
            data[left] = '9'; data[right] = '6'; helper(result, data, left+1, right-1);
            if(left != 0){
                data[left] = '0'; data[right] = '0'; helper(result, data, left+1, right-1);
            }
        }
    }
}
