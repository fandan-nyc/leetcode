public class LogSystem {
    TreeMap<Long, Integer> storage ; 
    Map < String, Integer > granularityMap ; 
    public LogSystem() {
        storage = new TreeMap<Long, Integer>();
        granularityMap  = new HashMap();
        granularityMap.put("Year", 4);
        granularityMap.put("Month", 7);
        granularityMap.put("Day", 10);
        granularityMap.put("Hour", 13);
        granularityMap.put("Minute", 16);
        granularityMap.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        storage.put(convertTimestamp(timestamp), id);
        return;
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        long start = granularity(s, gra, false);
        long end = granularity(e, gra, true);
        List<Integer> result = new ArrayList<Integer>();
        for(long key: storage.tailMap(start).keySet()){
            if(key < end){
                result.add(storage.get(key));
            }
        }
        return result;
    }
    
    private long convertTimestamp(String timestamp){
        long result = 0;
        for(char i: timestamp.toCharArray()){
            if(i >= '0' && i <= '9')
                result = result * 10 + (i-'0');
        }
        return result;
    }
    
    private long granularity(String a, String gra, boolean isEnd){
        int digits = granularityMap.get(gra);
        long result = 0;
        for(int i = 0 ; i < a.length();i++){
            if(a.charAt(i) != ':'){
                if(i < digits-1){
                    result = result * 10 + a.charAt(i) - '0';
                }else if(i == digits-1){
                    result = result * 10 + a.charAt(i) - '0' + (isEnd ? 1:0);
                }else{
                    result = result * 10;
                }
            }
        }
        return result;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
