class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        res.add(0);
        final int len = nums.length;
        Node root = new Node(nums[len-1]);
        for(int i = len-2; i >= 0; i--){
            int count = insertNode(nums[i], root);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }
    
    private int insertNode(int curr, Node root){
        int rightCount = 0;
        while(true){
            if(curr <= root.val){
                root.leftCount ++;
                if(root.left == null){
                    root.left = new Node(curr);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                rightCount += root.leftCount;;
                if(root.right == null){
                    root.right = new Node(curr);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return rightCount ;
    }
    
    
    class Node {
        int leftCount = 1;
        int val;
        Node left;
        Node right;
        
        Node(int val){
            this.val = val;
        }
    }
}
