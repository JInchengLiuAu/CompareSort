package Sort;

public class InsertSortClass 
{
	private int[] sortList;             
	private int moveNumber;             
	private int compareNumber;          
	
	public InsertSortClass(int[] list)
	{
		this.sortList = list;
		this.moveNumber = 0;
		this.compareNumber = 0;
	}
	
	public void insertSort() 
	{
		int i, j, temp;
		int k1, k2; 

		for (i = 0; i < sortList.length - 1; i++)
		{
			temp = sortList[i + 1];
			k1 = i + 1;
			j = i;

			while (j > -1 && temp <= sortList[j]) 
			{
				sortList[j + 1] = sortList[j];
				this.moveNumber++;
				j--;
			}
			if (sortList[j + 1] == temp)
			{
				sortList[j + 1] = temp;
				k2 = j + 1;
			} 
			else 
			{
				sortList[j + 1] = temp;
				this.moveNumber += 3;
				k2 = j + 1;
			}

			if (i == 0)
			{
				this.compareNumber++;
			}
			else 
			{
				this.compareNumber = this.compareNumber + (k1 - k2 + 1);
			}
		}

	}
	

	public int getCompareNumber()
	{
		return compareNumber;
	}
	

	public int getMoveNumber()
	{
		return moveNumber;
	}
}
