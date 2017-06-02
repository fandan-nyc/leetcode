public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        char[] data = s.toCharArray();
        for(int i = 0; i < s.length()-1; i++){
            if(data[i] == data[i+1] && data[i] == '+'){
                data[i] = '-';
                data[i+1] = '-';
                result.add(new String(data));
                data[i] = '+';
                data[i+1] = '+';
            }
        }
        return result;
    }
}
