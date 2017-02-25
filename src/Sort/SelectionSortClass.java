package Sort;

public class SelectionSortClass 
{
	private int[] sortList;           
	private int moveNumber;            
	private int compareNumber;         
	private int keyWord;               
	

	public SelectionSortClass(int[] list)
	{
		this.sortList = list;     
		this.moveNumber = 0;
		this.compareNumber = 0;
		this.keyWord = list[0];         
	}

	public void selectionSort() 
	{
		for (int i = 0; i < sortList.length - 1; ++i) 
		{
			int k = i;
			for (int j = i; j < sortList.length; ++j) 
			{
				if (sortList[k] > sortList[j])
				{
					if(sortList[k] == keyWord || sortList[j] == keyWord)
						compareNumber++;
					k = j;
				}
			}
			
			if (k != i) 
			{
				if(sortList[k] == keyWord || sortList[i] == keyWord)
					moveNumber++;
				int temp = sortList[i];
				sortList[i] = sortList[k];
				sortList[k] = temp;
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
