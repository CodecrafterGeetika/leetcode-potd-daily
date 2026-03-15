// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str," ",0);
    }
    
    public static void findSubsets (String str, String ans, int i) {
       //base case
       if (i==str.length()) {
           System.out.println(ans);
           return;
       }
       //yes
       findSubsets(str, ans+str.charAt(i), i+1);
       //no
       findSubsets(str,ans,i+1);
    }
}
