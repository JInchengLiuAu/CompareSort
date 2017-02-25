package Sort;

public class HeapSortClass 
{
	private int moveNumber; 
	private int compareNumber; 

	public HeapSortClass(int[] list) 
	{
		int temp;
		this.setMoveNumber(0);     
		this.setCompareNumber(0);  
		int n = list.length;
		initCreateHeap(list);

		for (int i = n - 1; i > 0; i--) 
		{ 
			this.setCompareNumber(this.getCompareNumber() + 1);
			this.setMoveNumber(this.getMoveNumber() + 1);
			temp = list[0];
			list[0] = list[i];
			list[i] = temp;

			createHeap(list, i, 0);
		}
	}

	public void createHeap(int[] a, int n, int h) 
	{
		int i, j, flag;
		int temp;

		i = h;                    
		j = 2 * i + 1;            
		temp = a[i];
		flag = 0;


		while (j < n && flag != 1) 
		{
			
			if (j < n - 1 && a[j] < a[j + 1]) 
			{
				this.setCompareNumber(this.getCompareNumber() + 1);
				j++;
			}

			if (temp > a[j]) 
			{
				flag = 1;
				this.setCompareNumber(this.getCompareNumber() + 1);
			} else {
				a[i] = a[j];
				i = j;
				j = 2 * i + 1;
				this.setMoveNumber(this.getMoveNumber() + 1);
			}
		}
		a[i] = temp;
	}

	public void initCreateHeap(int[] a) 
	{
		int n = a.length;
		for (int i = (n - 1) / 2; i >= 0; i--)
			createHeap(a, n, i);
	}


	public int getMoveNumber()
	{
		return moveNumber;
	}

	public void setMoveNumber(int moveNumber) 
	{
		this.moveNumber = moveNumber;
	}


	public int getCompareNumber() 
	{
		return compareNumber;
	}

	public void setCompareNumber(int compareNumber)
	{
		this.compareNumber = compareNumber;
	}
	
	
}
