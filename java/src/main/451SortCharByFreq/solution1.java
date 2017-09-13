class Solution {
    public String frequencySort(String s) {
    	Map<Character, Node> map = new HashMap<>();
    	for(char i: s.toCharArray()){
    		map.putIfAbsent(i, new Node(i, 0));
    		map.get(i).count++;
    	}
    	Comparator cm = new Comparator<Node>(){
    		@Override
    		public int compare(Node a, Node b){
    			return a.count - b.count;
    		}
    	};
    	PriorityQueue<Node> pq = new PriorityQueue<>(10, Collections.reverseOrder(cm));
    	for(Map.Entry<Character, Node> entry: map.entrySet()){
    		pq.add(entry.getValue());
    	}
    	StringBuilder sb = new StringBuilder();
    	while(pq.isEmpty() == false){
    		Node node = pq.remove();
    		for(int i = 0; i < node.count;i++){
    			sb.append(node.val);
    		}
    	}
    	return sb.toString();
    }
}

class Node {
	char val;
	int count;

	Node(char val, int count){
		this.val = val;
		this.count = count;
	}
}
