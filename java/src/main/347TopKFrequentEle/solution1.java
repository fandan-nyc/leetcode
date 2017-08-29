class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i: nums){
            count.put(i, count.getOrDefault(i,0)+1);
        }
        Comparator<Node> comparatoer = new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return a.count - b.count;
            }
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(10, Collections.reverseOrder(comparatoer));
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        List<Integer> res = new ArrayList<>();
        while( pq.isEmpty() == false && k > 0){
            res.add(pq.remove().val);
            k--;
        }
        return res;
    }
}

class Node{
    int val;
    int count;
    Node(int val, int count){
        this.val = val;
        this.count = count;
    }
}

