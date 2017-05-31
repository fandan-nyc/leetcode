class TwoSum {

    /** Initialize your data structure here. */
    private Map<Integer, Integer> store;
    public TwoSum() {
        store = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(store.containsKey(number)){
            store.put(number, 2);
        }else {
            store.put(number,1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Integer> values = store.keySet().iterator();
        while(values.hasNext()){
            int current = values.next();
            int other = value - current;
            if(store.containsKey(other)){
                if(other != current || store.get(other) == 2){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
