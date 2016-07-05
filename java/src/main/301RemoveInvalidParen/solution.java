public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> stored = new HashSet<String>();
        queue.add(s);
        boolean found  = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String tmp = queue.poll();
                if(isvalid(tmp)){
                    result.add(tmp);
                    found = true;
                }
                else{
                    for(int i = 0; i < tmp.length(); i ++){
                        if(tmp.charAt(i) != '(' && tmp.charAt(i) != ')'){
                            continue;
                        }
                        String tmpSub = tmp.substring(0,i) + tmp.substring(i+1);
                        if(stored.contains(tmpSub) == false){
                            stored.add(tmpSub);
                            queue.add(tmpSub);
                        }
                    }
                }
                size -- ;
            }
            if(found){
                return result;
            }
        }
        return result;
    }
    
    private boolean isvalid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '('){
                count ++;
            }else if(tmp == ')'){
                if(count == 0){
                    return false;
                }
                count --;
            }
        }
        return count == 0 ;
    }
}
