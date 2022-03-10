package tasks;

public class NamedTasks extends Tasks{
	private int [] arr;//the same as names but int
	private String [] names;
	// counstrctor for named tasks class
	public NamedTasks(String[] names)
	{
		super(names.length);
		this.names=names;
		arr=new int[names.length];//same array as names but int 
		for(int i=0;i<names.length;i++)
			arr[i]=i;
	}
	
	// this function connect between 2 tasks if one of them is depends on other 
	public boolean dependsOn(String task1, 
            String task2)
	{
		int x=-1,y=-1;//starting values
		for(int i=0;i<names.length;i++)
		{
			if(names[i]==task1) x=i;//index of task1 in names
			if(names[i]==task2) y=i;//idex of task2 in names

		}
		return super.dependsOn(x,y);
			}
	
	// this function order tasks by depends 
	public String[] nameOrder()
	{
		int [] result=new int[names.length];//result int array
		result=order();
		String [] strresult= new String [names.length];//result strings array
		for(int i=0;i<names.length;i++)
		{
			for(int j=0;j<names.length;j++)
				if(result[i]==arr[j])//put the string in strresult after finding the index in by using arr
					strresult[i]=names[j];
				
			}
		return strresult;
		}
		
		
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	

	
	
	

