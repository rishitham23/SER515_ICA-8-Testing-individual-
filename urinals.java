/*
Author: Rishitha Malempati
 */
import java.util.*;

public class urinals {
    public static void main(String[] args) {
        urinals ur=new urinals();
        System.out.println(ur.goodString("1100"));
    }

    boolean goodString(String str) {
        String[] a=str.split("");
        boolean isValid=true;
        int len = a.length;
        for (int i = 0; i < len-1; i++)
        {
            int j=Integer.parseInt(String.valueOf(a[i]));
            int k=Integer.parseInt(String.valueOf(a[i+1]));
            if (j==1 && k==1)
            {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}