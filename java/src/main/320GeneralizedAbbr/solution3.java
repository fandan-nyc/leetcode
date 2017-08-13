public class Solution {
    public List<String> generateAbbreviations(String word) {
        if(word == null ){
            return new ArrayList<String>();
        }else if(word.equals("")){
            return Arrays.asList("");
        }
        List<String> res = new ArrayList<>();
        DFS(word.toCharArray(), 0, 0, new StringBuilder(), res);
        return res ;         
    }
    
    private void DFS(char[] input, int count, int num, StringBuilder sb, List<String> res){
        int len = sb.length();
        if(count == input.length){
            if(num != 0){
                sb.append(num);
            }
            res.add(sb.toString());
        }else{
            DFS(input, count+1, num+1, sb, res);
            if(num != 0)
                sb.append(num);
            DFS(input, count+1, 0, sb.append(input[count]), res);
        }
        sb.setLength(len);
    }
    
}
