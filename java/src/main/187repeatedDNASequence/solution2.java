public class Solution {
    
    private Map<Character, Integer> map = new HashMap<Character, Integer>();
    
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <= 10){
            return new ArrayList<String>();
        }
        map.put('A', 0);
        map.put('T', 1);
        map.put('G', 2);
        map.put('C', 3);
        char[] sChar = s.toCharArray();
        int hashCode = 0;
        int mask = (1<< 18)-1;
        for(int i = 0; i < 10; i++){
            hashCode = (hashCode <<2) + map.get(sChar[i]);
        }
        // assume that there is no collision
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(hashCode, 9);
        HashSet<Integer> stored =  new HashSet<>();
        List<String> result = new ArrayList<String>() ;
        for( int i = 10; i <= sChar.length -1; i++){
            hashCode = ((hashCode & mask)<< 2) + map.get(sChar[i]);
            if(!hashMap.containsKey(hashCode)){
                hashMap.put(hashCode, i );
            }else if(stored.contains(hashMap.get(hashCode)) == false){
                result.add(s.substring(i-9,i+1));
                stored.add(hashMap.get(hashCode));
            }
        }
        return result;
    }
}
