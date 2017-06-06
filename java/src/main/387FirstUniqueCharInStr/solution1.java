public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        Queue<Integer> data = new LinkedList<>();
        Set<Character> visited = new HashSet<Character>();
        Set<Character> dup = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(visited.contains(curr)){
                dup.add(curr);
            }else{
                data.add(i);
                visited.add(curr);
            }
        }
        while(data.isEmpty()==false){
            int head = data.remove();
            if(!dup.contains(s.charAt(head))){
                return head;
            }
        }
        return -1;
        
    }
}
