package hash;
import java.util.*;
public class leetcode299 {
    public String getHint(String secret, String guess) {
        int[] countA = new int[10];
        int[] countB = new int[10];
        int lens = secret.length();
        char[] s = secret.toCharArray(),g = guess.toCharArray();
        int A=0,B=0;
        for(int i=0;i<lens;i++){
            if(s[i]==g[i]){
                A++;
            }
            else {
                countA[s[i]-'0']++;
                countB[g[i]-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            B += Math.min(countA[i],countB[i]);
        }
        return A+"A"+B+"B";
    }
}
