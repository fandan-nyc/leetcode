char* reverseString(char* s) {
    if(s == NULL || *s == '\0' || *(s+1) == '\0'){
        return s;
    }
    int i = 0; 
    char * tmp = s; 
    while( *(tmp++) != '\0'){
        i++;
    }
    --i;
   int j = 0;
   while(j < i){
       char tmp = s[i];
       s[i] = s[j];
       s[j] = tmp;
       --i;
       ++j;
   }
   return s;
}
