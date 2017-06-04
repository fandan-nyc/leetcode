public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String i: strs){
            result.append(i.length() + "/");
            result.append(i);
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int i = 0; 
        while(i < s.length()){
            int slash = s.indexOf("/",i);
            int length = Integer.valueOf(s.substring(i,slash));
            result.add(s.substring(slash+1, slash+1+length));
            i = slash+length+1;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
