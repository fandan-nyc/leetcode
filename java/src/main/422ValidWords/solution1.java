public class Solution {
    public boolean validWordSquare(List<String> words) {
        List<String> columnToRow = columnToRow(words);
        if(words.size() != columnToRow.size()){
            return false;
        }
        for(int i = 0; i < words.size(); i++){
            if(!words.get(i).equals(columnToRow.get(i))){
                return false;
            }
        }
        return true;
    }
    
    private List<String> columnToRow(List<String> words){
        List<String> result = new LinkedList<>();
        int count = 0;
        while(count < words.get(0).length()){
            String tmp = "";
            for(int i = 0; i < words.size(); i++){
                if(count < words.get(i).length()){
                    tmp += words.get(i).charAt(count);
                }else{
                    break;
                }
            }
            result.add(tmp);
            count++;
        }
        return result;
    }
}
