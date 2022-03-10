package tree;

import java.util.Scanner;

public class ReversedWords {
	public static int checkReversed()
	{
        String str;
        int counter=0;
        Scanner myObj = new Scanner(System.in); //scanner
        str=myObj.next();
        Node n=new Node();
        n.add(str);
        while(!(str.equals("x")) && myObj.hasNext())
        {
        	if(n.num(str)==0)//if it's not in the tree
        		{
            	if(ReverseBool(str,n)==true)//use ReverseBool and counting if it's true
            		counter++;
            	 n.add(str);
        		}
        	else
        	{
        		if(ReverseBool(str,n)==true)
        		counter++;
        	}
        	str=myObj.next();		
	}
        myObj.close();
        return counter;

	}
	private static boolean ReverseBool(String s,Node nod)
	{//reverse the string s and check if the reversed string in the nod
		String temp;
		char [] a=new char[s.length()];
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(s.length()-i-1);//take last char
			a[i]=c;
		}
		temp=String.valueOf(a);//convert the chars arr a to string
		if(nod.num(temp)>0)return true;//if the reverse string in the tree
		else return false;
		
	}
	
	
	
	
	
	
	
	
}
