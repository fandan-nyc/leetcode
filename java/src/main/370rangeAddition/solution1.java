public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
    Map<String, Integer> ops = new HashMap<String, Integer>();
    for(int[] i:updates){
        int start = i[0];
        int end = i[1];
        String pos = start  + "-" + end;
        ops.putIfAbsent(pos, 0);
        ops.put(pos, ops.get(pos) + i[2]);
    }
    int[] data = new int[length];
    for(String pos: ops.keySet()){
        int start = Integer.valueOf(pos.substring(0, pos.indexOf("-")));
        int end = Integer.valueOf(pos.substring(pos.indexOf("-")+1, pos.length()));
        for(int i = start; i <= end; i++){
            data[i] += ops.get(pos);
        }
    }
    return data;
    }
}
