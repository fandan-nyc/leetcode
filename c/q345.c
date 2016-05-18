
static int isVowel(char t){
    if(t == 'a' || t =='e' || t == 'i' || t == 'o' || t == 'u' ||t == 'A' || t =='E' || t == 'I' || t == 'O' || t == 'U')
        return 1;
    else
        return 0 ;
}
static void swap(char *s, int i, int j){
    char tmp = s[i];
    s[i] = s[j];
    s[j] = tmp;
}
char* reverseVowels(char* s) {
    int end = 0;
    while( s[end] != '\0'){
        ++end;
    }
    int start  = 0; 
    while(start < end){
        while(start < end && isVowel(s[start]) == 0){
            ++start;
        }
         while(start < end && isVowel(s[end]) == 0){
            --end;
        }
        if(start < end){
            swap(s,start, end);
        }
        ++start;
        --end;
    }
    return s;
}

