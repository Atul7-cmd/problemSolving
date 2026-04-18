// class Solution {
//     public boolean isPalindrome(String s) {
//       StringBuilder sb=new StringBuilder();
//       int n=s.length();
//       for(int i=0;i<n;i++){
//         char ch=s.charAt(i);
//         if(Character.isUpperCase(ch)){
//             char c=Character.toLowerCase(ch);
//             sb.append(c);
//         }
//         if((ch>='0' && ch<='9')||(ch>='a'&&ch<='z')){
//             sb.append(ch);
//         }
//       }  
//       String ori=sb.toString();
//       String rev=sb.reverse().toString();
//      return ori.equals(rev);
//     }
// }

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        String ori = sb.toString();
        String rev = new StringBuilder(ori).reverse().toString();

        return ori.equals(rev);
    }
}