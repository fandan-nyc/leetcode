public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> store = new HashMap<>();
        for(String i: paths){
            String[] splited = i.split(" ");
            String dir = splited[0];
            for(int j = 1; j < splited.length; j++){
                String[] file = splited[j].split("\\(");
                String path = file[0];
                String content = file[1];
                content = content.substring(0,content.length()-1);
                store.putIfAbsent(content, new ArrayList<String>());
                store.get(content).add(dir + "/" + path);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> i: store.values()){
            if(i.size() > 1)
                result.add(i);
        }
        return result;
    }
}
