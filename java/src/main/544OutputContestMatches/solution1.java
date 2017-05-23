public class Solution {
    public String findContestMatch(int n) {
        List<String> teams =  new ArrayList<>();
        for(int i = 1; i <= n; i++){
            teams.add(String.valueOf(i));
        }
        while(teams.size() != 1){
            teams = getNextRound(teams);
        }
        return teams.get(0);
    }
    
    private List<String> getNextRound(List<String> input){
        int start  = 0; 
        int end = input.size() -1; 
        List<String> output = new ArrayList<String>();
        while(start < end){
            output.add( "(" + input.get(start++) + "," + input.get(end --) + ")" );
        }
        return output;
    }
}
