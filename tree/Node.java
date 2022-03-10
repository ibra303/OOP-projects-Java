package tree;

public class Node {
	private int count=0;
	private Node[] children;
	// constructor for node 
	public Node ()
	{
		children=new Node[26];
	}
	//
	public int num(String s)
	{
		if(s.contentEquals("")) return count;//if it's empty 
	  char c=s.charAt(0);//take the first char
	  if(children[c-'a']==null) return 0;
	  
	  return children[c-'a'].num(s.substring(1));//delete first char and repeat

	}
	// add string to tree
	public void add(String s)
	{//add string s to the tree
		int i;
		Node a=this;
	    for(i=0;i<s.length();i++)
	    {
	    	char c=s.charAt(i);//take the i char
            if(a.children[c-'a']==null)
            {
            	a.children[c-'a']=new Node();
            	a=a.children[c-'a'];
            }
            else 
            	a=a.children[c-'a'];
	    }
	    a.count++;
	}
		
	
	
	
	
	
}