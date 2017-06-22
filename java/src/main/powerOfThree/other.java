/*
* the other ideas are 
* a. the max power of 3 int is 1162261467, so return x > 0 && 1162261467%n == 0;
* b. convert to base 3. it has to be 10....0 return Integer.toString(n, 3).matches("^10*$");
* c. 3^i = n; then log(n) / log(3) %1 <= 2 * epsilon
*/
