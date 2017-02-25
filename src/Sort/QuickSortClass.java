package Sort;

public class QuickSortClass 
{
	private int[] sortList;             
	private int moveNumber;             
	private int compareNumber;          
	
	
	public QuickSortClass(int[] list)
	{
		this.sortList = list;
		this.compareNumber = 0;
		this.moveNumber = 0;
	}
	
	
	public void quickSort()
	{
		quickSort(sortList, 0, sortList.length - 1);
	}
	

	public  void quickSort(int[]a,int low,int high)
	{
		int i=low;
		int j=high;
		int temp=a[low];
		int n=a.length;
		int b=(int) Math.pow(n, (1/3));
		while(i<j)
		{
			while(i<j&&temp<=a[j])
			{
				this.compareNumber++;
				j--;
			}
			if(i<j)
			{
				a[i]=a[j];
				this.moveNumber+=1;
				i++;
			}
			while(i<j&&a[i]<temp)
			{
				this.compareNumber++;
				i++;
				}
			if(i<j)
			{
				a[j]=a[i];
				this.moveNumber+=1;
				j--;
			}	
		}
		a[i]=temp;
		if(low<i) quickSort(a,low,i-1);
		if(i<high) quickSort(a,j+1,high);
	}
	

	public int getMoveNumber()
	{
		return moveNumber;
	}
	

	public int getCompareNumber()
	{
		return compareNumber;
	}
}
