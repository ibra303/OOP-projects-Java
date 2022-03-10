package bank;

public class ProAccount extends Account {
	
	private int beforBudget[]= new int[100];
	private int now=0;
	// constructor for a pro account
	public ProAccount(String name) { 
		super(name);
	}
	// add amount to account
	public void add(int amount) 
	{ 
		if(now != 100)
		{
			this.now++;
			this.beforBudget[now]+=this.beforBudget[now-1]+ amount;
			}
	}
	// return string with all info for the account (budget now and before)
	public String toString() 
	{
		int i=0;
		String str2=" [", str1 = this.getName() +" has "+ this.beforBudget[now] +" shekels";
		for ( i=1 ; i < now+1 ; i++)
		{
		str2 += this.beforBudget[i];
		if(i!=now)
		str2+=",";
		}
	    str2+="]";
	    str1+=str2;
	    return str1 ;
	}
	// transfer money between 2 accounts  
	public static void transfer(ProAccount from,ProAccount to,int amount)
	{
		from.now++;
		from.beforBudget[from.now]=from.beforBudget[from.now-1] - amount;
		to.now++;
		to.beforBudget[to.now]=to.beforBudget[to.now-1] + amount;
		
	}
	}
