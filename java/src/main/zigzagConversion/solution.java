
public class Solution{
  public String convert(String s, int numRows)
  {
    if(numRows <= 1 || numRows > s.length())
    {
      return s;
    }
    StringBuffer[] tmp = new StringBuffer[numRows];
    int p = 2 * numRows - 2 ; 
    for(int i = 0; i < s.length();i++)
    {
      int position = ((i% p)>= numRows )? (p - i%p) : (i%p);
      if(tmp[position] == null)
      {
        tmp[position]= new StringBuffer();
      }
        tmp[position].append(s.charAt(i)); 
    }
    StringBuffer result = new StringBuffer();
    for(StringBuffer i: tmp)
    {
      result.append(i);
    } 
    return result.toString();
  }

}
