public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordMap = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String current = words[i];
            if(wordMap.containsKey(current)){
                wordMap.get(current).add(i);
            }else{
                wordMap.put(current, new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
        List<Integer> pos1 = wordMap.get(word1);
        List<Integer> pos2 = wordMap.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i: pos1){
            for(int j: pos2){
                min = Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}
