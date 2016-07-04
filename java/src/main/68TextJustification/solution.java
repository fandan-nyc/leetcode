public class Solution {
    public List<String> fullJustify(String[] words, final int maxWidth) {
        List<String> result = new ArrayList<String>();
        if(words == null || words.length == 0){
            return result;
        }
        int start = 0; 
        while(start < words.length){
            int end = start;
            int currWidth = 0;
            while( currWidth <= maxWidth+1 && end < words.length){
                currWidth += (words[end].length() +1);
                end++;
            }
            if(currWidth > maxWidth+1){
                currWidth -= (words[end-1].length()+1);
                end --;
            }
            currWidth = currWidth -1;
            end --;
            StringBuilder sb = new StringBuilder(words[start]);
            if(end == start){
                sb.append(nSpace(maxWidth - words[end].length()));
            }else if( end == words.length-1){
                 int count = start+1;
                 int total = words[start].length();
                 while(count <= end){
                     sb.append(" ");
                     sb.append(words[count]);
                     total += (1 + words[count].length());
                     count++;
                 }
                 sb.append(nSpace(maxWidth - total));
            }
            else{
                final int averageSpace = (maxWidth - currWidth + end -start) / (end - start);
                int extra = (maxWidth - currWidth + end - start)%(end - start);
                int count = start+1;
                while(count <= end){
                    if(extra > 0){
                        sb.append(nSpace(averageSpace+1));
                        extra --;
                    }else{
                        sb.append(nSpace(averageSpace));
                    }
                    sb.append(words[count]);
                    count++;
                }
            }
            result.add(sb.toString());
            start = end+1;
        }
        return result;
    }
    
    private String nSpace(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n ;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
