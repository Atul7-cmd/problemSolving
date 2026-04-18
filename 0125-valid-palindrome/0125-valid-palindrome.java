class Solution {
    public boolean isPalindrome(String s) {
      StringBuilder sb=new StringBuilder();
      int n=s.length();
      for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        if(Character.isUpperCase(ch)){
            char c=Character.toLowerCase(ch);
            sb.append(c);
        }
        if((ch>='0' && ch<='9')||(ch>='a'&&ch<='z')){
            sb.append(ch);
        }
      }  
      String ori=sb.toString();
      String rev=sb.reverse().toString();
     return ori.equals(rev);
    }
}