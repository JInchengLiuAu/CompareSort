package Sort;

public class ShellSortClass 
{
	private int[] sortList;             
	private int moveNumber;             
	private int compareNumber;         
	
	public ShellSortClass(int[] list)
	{
		this.sortList = list;
		this.compareNumber = 0;
		this.moveNumber = 0;
		int od[]={4,2,1};
		shellSort(sortList, od, 2);
	}

	public void shellSort(int[]a,int[]d,int dk) 
	{
		int k1,k2;     
		int m,k,i;
		
		for(m=0;m<dk;m++){  
			int span=d[m]; 
			
			for(k=0;k<span;k++){
			for(i=k;i<a.length-span;i=i+span){
				int temp=a[i+span];
				k1=i+span;
				int j=i;
				
				while(j>-1&&temp<=a[j]){
					a[j+span]=a[j];
					j=j-span;
					this.moveNumber++;
					}
				if(a[j+span]==temp){
					a[j+span]=temp;
					k2=j+span;
					}
				else{
					a[j+span]=temp;
					this.moveNumber+=3;
					k2=j+span;
				  }
				  
			if(i==k)
			this.compareNumber++;
			else{
			this.compareNumber=this.compareNumber+(k1-k2+1);
			}
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