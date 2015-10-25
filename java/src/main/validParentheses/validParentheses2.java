public class Solution 
{
	public boolean isValid(String s)
	{
		if(s == null || s.length() == 0)
		{
			return true;
		}
		Stack<Character> result = new Stack<Character>();
		for(Character i: s.toCharArray())
		{
			if(i == '(' || i == '{' || i == '[')
			{
				result.push(i);
			}
			// assume that, the string contains valid parenthesis char only
			else 
			{
			    if(result.isEmpty())
			    {
			        return false;
			    }
				Character p = result.pop();
			    if( i -  p != 1 && i - p != 2)
			    {
			        return false;
			    }
			}
		}
		return result.size() == 0 ;
	}
}
