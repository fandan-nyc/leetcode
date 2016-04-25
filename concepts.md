**Tree**
<hr>
1. what is preorder traversal ?
   Answer: root -> left -> right
2. what is inorder traversal ?
   Answer: symmetric. left -> middle -> right
3. what is post order ?
   Answer: left -> right -> middle

**Java API**
<hr>
1. how to fill an array with specific value; 
   Answer: Arrays.fill(array, -1);
2. how to copy an array: x.clone();
3. Integer.toString(X);
4. StringBuffer x =  new StringBuffer(); x.insert( 5, 't');
5. Arrays.asList(1,2,3,4); # the list length fixed. 
6. to have an array which can change length, List<String> strings = new ArrayList<>(asList("foo", "bar", "baz"));
7. you should do Stack<Character> but Stack<char> would fail for sure
8. queue --> linkedList
9. Character.toLowerCase(char)
10. \W mean non-word character \w mean word character, x.replaceAll("\\W","").toLowerCase();
11. >>> zero fill right shift. (We do not have <<< at all). for example, 60 (111100) zero fill right shift 2 should be 0000 1111, which is 15
12. Set x = new HashSet<Integer>(); x.add(12) return true when 12 is not in x and returns false when 12 is in x. 

**things to implement and learn**
<hr>
1. merge sort
2. leetcode question 18, better solutions in discussion
3. https://leetcode.com/discuss/74780/my-java-solution-using-min-heaps-implemented-by-myself 
4. KMP algorithm
5. BM (boyer-moore) algorithm
6. why hashMap, set .. cannot use primary data type
7. Boyer–Moore majority vote algorithm time O(n) space O(logn)

**注意事项**
<hr>
1. 写好之后检查自己的程序，不能依靠build 来检验
2. 自己写几个use case test 一下
3. 尽量想清楚，精简自己的程序
4. 写好之后看看能不能精简自己的程序
5. 
** to read **
https://leetcode.com/discuss/96442/my-c-solution-with-0ms

**questions missed** 

