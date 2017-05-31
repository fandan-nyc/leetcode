public class TwoSum {

    /** Initialize your data structure here. */
    private Set<Integer> sum ;
    private Set<Integer> data ; 
    public TwoSum() {
        sum = new HashSet<>();
        data = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(data.contains(number)){
            sum.add(number * 2);
        }else {
            Iterator<Integer> iter =data.iterator();
            while(iter.hasNext()){
                sum.add(iter.next()+number);
            }
            data.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
