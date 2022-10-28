/*
Author: Rishitha Malempati
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class urinals {
    boolean goodString(String str) {
        String[] a=str.split("");
        boolean isValid=true;
        @SuppressWarnings("unused") int len = a.length;
        for (int i = 0; i < a.length-1; i++)
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
        @SuppressWarnings("unused") boolean isValid=ur.goodString(str);
        int i,c= 0; //c:count
        String[] a=str.split("");
        int len= a.length;
//        int s[];
        @SuppressWarnings("CStyleArrayDeclaration") int s[]= new int[len];
        for (i=0;i<len;i++) {
            s[i]=Integer.parseInt(String.valueOf(a[i]));
        }
        if(len==1) {
            //noinspection LoopStatementThatDoesntLoop
            while(s[0]==0) {
                c=1;
                s[0]=1;
                break;
            }
        } else {
            i = 0;
            //noinspection LoopStatementThatDoesntLoop
            while(s[i]==0 && s[i+1]==0) {
                s[i]=1;
                c++;
                break;
            }
            for(i=1;i<len-1;i++) {
                if (s[i-1]==0 && s[i]==0 && s[i+1]==0) {
                    s[i]=1; c++;
                }
            }
            if(s[i-1]==0 && s[i]==0) {
                s[i]=1; c++;
            }
        }
        return c;
    }

    @SuppressWarnings("unused")
    public void openFile(String path)
            throws IOException {
        try {
            urinals ur=new urinals();
            File fl=new File(path);
            while(fl==null) {
                throw new IOException();
            }
            File cfl=new File("src/test/total.txt");
            while(cfl==null) {
                throw new IOException();
            }
            Scanner c=new Scanner(cfl);
            int total=Integer.parseInt(c.nextLine());

            String opfl="src/main/rule.txt";
            if(total!=0)
                opfl="src/main/rule"+total+".txt";

            Scanner sc=new Scanner(fl);
            while(sc.hasNextLine()){
                String st=sc.nextLine();
                if(st.equals("-1"))
                    break;
                int free=ur.countUrinals(st);
                ur.writeToFile(opfl,free);
            }
            FileWriter cw=new FileWriter("src/test/total.txt");
            while(cw==null) {
                throw new IOException();
            }
            cw.write(Integer.toString(total+1));
            cw.close();

            System.out.println("Output successfully written in the file" +opfl);
        }
        catch(IOException e)
        {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    private void writeToFile(String opfl, int free) {
        try {
            FileWriter w=new FileWriter(opfl, true);
            while(w==null) {
                throw new IOException();
            }
            BufferedWriter bw=new BufferedWriter(w);
            while(bw==null) {
                throw new IOException();
            }
            bw.write(Integer.toString(free));
            bw.newLine();
            bw.close();
        }
        catch(IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner ip = new Scanner(System.in);
        System.out.println("Choose your input type:");
        System.out.println("Choose 1 for Keyboard");
        System.out.println("choose 2 for input values from file");
        int input = ip.nextInt();
        switch (input) {
            case 1:
                Scanner str = new Scanner(System.in);
                System.out.println("Enter a string containing 1s and 0s:");
                String a=str.next();
                urinals ur=new urinals();
                System.out.println(ur.goodString(a));
                break;
            case 2:
                System.out.println("taking input from the file");
                urinals cfl=new urinals();
                cfl.openFile("src/urinals.dat");
            default:
                System.out.println("invalid choice");
        }

    }

}