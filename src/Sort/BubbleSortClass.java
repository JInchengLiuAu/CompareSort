package Sort;

public class BubbleSortClass 
{
	private int[] sortList;             
	private int moveNumber;             
	private int compareNumber;          
	private int keyWord;                
	

	public BubbleSortClass(int[] list)
	{
		this.sortList = list;
		this.moveNumber = 0;
		this.compareNumber = 0;
		this.keyWord = list[0];
	}
	

	public void BubbleSort()
	{
		boolean needNextPass = true;
		for(int k  = 1; k < sortList.length && needNextPass; k++)
		{	
			for(int i = 0; i < sortList.length - k; i++)
			{
				if(sortList[i] == keyWord || sortList[i+1] == keyWord )
				{
					compareNumber++;
				}
				
				if(sortList[i] > sortList[i+1])
				{
					if(sortList[i] == keyWord || sortList[i+1] == keyWord )
					{
						moveNumber++;
					}
					int temp = sortList[i];
					sortList[i] = sortList[i+1];
					sortList[i+1] = temp;
					needNextPass = true;
				}
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
