public class Logger {

    /** Initialize your data structure here. */
    private Set<String> msgSet;
    private Queue<Node> nodeList ; 
    public Logger() {
        msgSet = new HashSet<>();
        nodeList = new LinkedList<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(nodeList.isEmpty() == false && timestamp >= nodeList.peek().timestamp + 10){
            msgSet.remove(nodeList.poll().message);
        }
        if(msgSet.add(message)){
            nodeList.add(new Node(message, timestamp));
            return true;
        }
        return false;
    }
}

class Node {
    String message; 
    int timestamp;
    
    Node(String msg, int timestamp){
        this.message = msg;
        this.timestamp = timestamp;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
