public class Solution {
    public String simplifyPath(String path) {
        String[] splitedPath = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String x: splitedPath )
        {
            if(x.equals(".") || x.equals(""))
            {
                continue;
            }
            else if(x.equals(".."))
            {
                  if(stack.isEmpty() == false)
                  {
                      stack.pop();
                  }
            }
            else 
            {
                stack.push(x);
            }
        }
        if(stack.isEmpty())
        {
            return "/";
        }
        else{
            StringBuffer sb = new StringBuffer();
            while(stack.isEmpty() == false)
            {
                sb.insert(0, stack.pop());
                sb.insert(0,"/");
            }
            return sb.toString();
        }
    }
}
