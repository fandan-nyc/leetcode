public class Logger {

    /** Initialize your data structure here. */
    private Map<String, Integer> logMap;
    public Logger() {
        this.logMap = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(logMap.containsKey(message) == false){
            logMap.put(message, timestamp);
            return true;
        }else{
            if(timestamp - logMap.get(message) >= 10){
                logMap.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
