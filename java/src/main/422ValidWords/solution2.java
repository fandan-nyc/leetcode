public class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.get(i).length(); j++){
                char tmp = words.get(i).charAt(j);
                if(j >= words.size() || i >= words.get(j).length() || tmp != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
