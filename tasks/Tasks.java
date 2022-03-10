package tasks;

public class Tasks {
	private int [][] arr;//matrix it represents the dependens
	private int num;//num of the all dependens 
	private int [] result;//the result array of function order
	private int size;//size of result in every call starting from 0
	public Tasks(int num)
	{
		this.num=num;
		arr=new int [num][num];
		result=new int [num];
		size =0;//result size in every call
	}
	public boolean dependsOn(int task1, int task2)//if task1 and task2 allowed numbers put 1 in arr[task1][task2] array of dependens
	{
		if(task1<0 ||task1>=num) return false;
		if(task2<0 ||task2>=num) return false;
		arr[task1][task2]=1;
		return true;
	}
	public int[] order()//orders the result array 'result' by calling check if there's enough space
	{
		int i;

	for(i=0;i<num;i++)
	{
		if(size<num) check(i);
		else i=num;//to exit the for
	}
	
	return result;
	}
	
	
	
	private void check(int x)//if the row 'x' has no dependences , adds x to the result array and delete it from other rows if it has dependence it calls the other dependence
	{
		int counter=0;
		for(int j=0;j<num;j++)
		{
			if(arr[x][j]==1)//there's dependence
			{
				check(j);//calls other dependece
				check(x);//back to x when finish other
			}
			else counter++;//number of empty dependences
		}
		if(counter==num && size<num)//if x has no dependences
		{
			result[size]=x;//adding x to result array and size++
			size++;
			for(int i=0;i<num;i++)//delete x from other rows
				if(arr[i][x]==1) arr[i][x]=0;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
