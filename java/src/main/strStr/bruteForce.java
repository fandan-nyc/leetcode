pubic class Solution{
	public int strStr(String text, String str){
		if(text == null || str == null)
			return -1;
		if(str.equals(""))
			return 0;
		if(text.equals(""))
			return -1;
		if(str.length() > text.length())
			return -1;
		int strPos = 0;
		for(int i = 0; i <= text.length()-str.length(); i++){
			while(strPos < str.length() && text.charAt(i+strPos) == str.charAt(strPos)){
				strPos++;
			}
			if(strPos == str.length()){
				return i;
			}
			else{
				strPos =0;
			}
		}
		return -1;
	}
}
