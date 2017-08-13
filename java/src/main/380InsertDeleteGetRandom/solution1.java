public class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> data; 
    Map<Integer, Integer> map;
    Random rand = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
        data = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, data.size());
        data.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos = map.get(val);
        if(pos < data.size()-1){
            swap(data, pos, data.size()-1);
        }
        data.remove(data.size()-1);
        map.remove(val);
        return true;
    }
    
    private void swap(List<Integer> i, int a, int b){
        int tmp = i.get(a);
        i.set(a, i.get(b));
        i.set(b,tmp);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(rand.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
