package StringRecursion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    String  a = "bccad";
    Main m2 =new Main();
    //String s1 = m2.removeCh(a,'c',0);
        System.out.println(m2.removeCh(a,'c',0));

    // subSeq
    String s1 = "abc";
    m2.subseq(s1,"");
    ArrayList<String> ans1 = m2.subSeq1("abc","");
        System.out.println(ans1);
    //m2.permutation("abc","");
        m2.permutation("abc","");

        System.out.println(m2.permutation2("abcde",""));
        System.out.println(m2.fact(10));

        System.out.println(m2.dice("",8));
    }

    public String removeCh(String str,char ch,int i){
        // bccad ==> bad

        String ans =new String();
        if(i==str.length()){
            return ans;
        }
        if(str.charAt(i) !=ch){
            ans+= str.charAt(i);
        }
        String ros = removeCh(str,ch,i+1);
        ans+= ros;

        return ans;
    }

    // subseq

    public void subseq(String ip,String op){
        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }
        char ch = ip.charAt(0);
        subseq(ip.substring(1),op);
        subseq(ip.substring(1),op+ch);


    }

    //
    public ArrayList<String> subSeq1(String ip,String op){
        ArrayList<String> res = new ArrayList<>();
        if(ip.isEmpty()){
            res.add(op);
            return res;
        }

        char ch = ip.charAt(0);
        ArrayList<String> leftList = subSeq1(ip.substring(1),op+ch);
        ArrayList<String> rightList = subSeq1(ip.substring(1),op);

        leftList.addAll(rightList);

        return leftList;


    }

    public void permutation(String ip,String op){

        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        for(int i = 0;i<=op.length();i++){
            String f = op.substring(0,i);
            String s = op.substring(i);
            permutation(ip.substring(1),f+ch+s);

        }


    }

    public ArrayList<String> permutation2(String ip,String op){
        ArrayList<String> res = new ArrayList<>();

        if(ip.isEmpty()){
            res.add(op);
            return res;
        }

        char ch = ip.charAt(0);
        ArrayList<String> roRes = new ArrayList<>();
        for(int i = 0;i<=op.length();i++){
            String f = op.substring(0,i);
            String s = op.substring(i);
            roRes.addAll(permutation2(ip.substring(1),f+ch+s));
        }
        res.addAll(roRes);

        return res;

     }

     public int fact(int n ){
        if(n == 0||n==1){
            return 1;

        }
        return n*fact(n-1);
     }

     public ArrayList<String> dice(String op,int target){
        ArrayList<String> res = new ArrayList<>();
        if(target ==0){
            res.add(op);
        }
         ArrayList<String> newRes = new ArrayList<>();
        for(int i =1;i<=6;i++){
            if(i<=target){
             newRes.addAll(dice(op+i,target-i));
            }
        }
        res.addAll(newRes);
        return res;
     }


}
