/*
Author: Rishitha Malempati
 */

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
    public int countUrinals(String str) {
        urinals ur=new urinals();
        boolean isValid=ur.goodString(str);
        int i,c= 0; //c:count
        String[] a=str.split("");
        int len= a.length;
//        int s[];
        int s[]= new int[len];
        for (i=0;i<len;i++) {
            s[i]=Integer.parseInt(String.valueOf(a[i]));
        }
        if(len==1) {
            while(s[0]==0) {
                c=1;
                s[0]=1;
                break;
            }
        } else {
            i = 0;
            while(s[i]==0 && s[i+1]!=1) {
                s[i]=1;
                c++;
                break;
            }
            for(i=1;i<len-1;i++) {
                if (s[i-1]!=1 && s[i]==0 && s[i+1]!=1) {
                    s[i]=1; c++;
                }
            }
            if(s[i-1]!=1 && s[i]==0) {
                s[i]=1; c++;
            }
        }
        return c;
    }
}