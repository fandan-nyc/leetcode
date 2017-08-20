{
    private Map<String, Long> data;
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        data = new HashMap<>();
        return (int)helper(s);
    }
    
    private long helper(String s){
        if(s.length() == 0){
            return 1;
        }
        // if(data.containsKey(s)){
        //     return data.get(s);
        // }
        long total = 0;
        // use single
        if(s.charAt(0) == '0'){
            return 0;
        }else if(s.charAt(0) == '*'){
            total += (9 * helper(s.substring(1)));
        }else{
            total += helper(s.substring(1));
        }
        if(s.length() >= 2){
             // use two chars
            if(s.substring(0,2).lastIndexOf("*") == -1){
                total += Integer.valueOf(s.substring(0,2)) <= 26 ? helper(s.substring(2)) : 0;
            }else{
                int firstStart = s.charAt(0) == '*' ? 1: Integer.valueOf(s.charAt(0)+"");
                int firstEnd = s.charAt(0) == '*' ? 9: Integer.valueOf(s.charAt(0)+"");
                int secondStart = s.charAt(1) == '*' ? 1: Integer.valueOf(s.charAt(1)+"");
                int secondEnd = s.charAt(1) == '*' ? 9: Integer.valueOf(s.charAt(1)+"");
                for(int i = firstStart; i <= firstEnd; i++){
                    for(int j = secondStart; j <= secondEnd; j++){
                        total += (i*10+j) <= 26 ? helper(s.substring(2)) : 0;
                    }
                }
            }
        }
       // data.put(s, total);
        return total;
    }
}
