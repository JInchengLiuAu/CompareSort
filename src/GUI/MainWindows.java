package GUI;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Sort.*;


public class MainWindows extends JFrame implements Runnable
{
	private JPanel sortPanel;              
	private JMenuBar jmbMenu;               
	private JLabel bubbleSortLabel;         
	private JLabel heapSortLabel;          
	private JLabel insertSortLabel;         
	private JLabel quickSortLabel;         
	private JLabel selectionSortLabel;     
	private JLabel shellSortLabel;         
	private JLabel moveNumberLabel;        
	private JLabel compareNumberLabel;      
	/*
	 * private JButton bubbleSortButton;       
	private JButton heapSortButton;        
	private JButton insertSortButton;      
	private JButton quickSortButton;        
	private JButton selectionSortButton;  
	private JButton shellSortButton;        
	*/
	private JMenu controlMenu;             
	private JMenuItem showDataItem;             
	private JMenuItem startItem;           
	private JMenuItem closeItem;            
	//private JTable    resultTable;         
	private List<Integer> dataList; 
	private static int number;             
	
	Thread thread = new Thread(this);

	public MainWindows()
	{
		super("Analyse Sort Algorithms");
		this.jmbMenu = new JMenuBar();
		this.controlMenu = new JMenu("Control");
		this.startItem = new JMenuItem("Start");
		this.startItem.addActionListener(new stratAction());
		this.showDataItem = new JMenuItem("Display numbers");
		this.showDataItem.addActionListener(new showAction());
		this.closeItem = new JMenuItem("Quit");
		this.closeItem.addActionListener(new closeAction());
		this.controlMenu.add(startItem);
		this.controlMenu.add(showDataItem);
		this.controlMenu.add(closeItem);
		this.jmbMenu.add(controlMenu);
		this.setJMenuBar(jmbMenu);
		
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y  = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.sortPanel = new JPanel();
		this.sortPanel.setLayout(null);
		this.bubbleSortLabel     = new JLabel("Bubble Sort");
		this.heapSortLabel       = new JLabel("Heap Sort");
		this.insertSortLabel     = new JLabel("Insertion Sort");
		this.quickSortLabel      = new JLabel("Quick Sort");
		this.selectionSortLabel  = new JLabel("Selection Sort");
		this.shellSortLabel      = new JLabel("Shell Sort");
		this.moveNumberLabel     = new JLabel("  Move");
		this.compareNumberLabel  = new JLabel("Comparison");
		
		compareNumberLabel.setBounds(140, 30, 100, 30);
		moveNumberLabel.setBounds(220, 30, 100, 30);
		bubbleSortLabel.setBounds(30, 60, 100, 30);
		heapSortLabel.setBounds(30, 90, 100, 30);
		insertSortLabel.setBounds(30, 120, 100, 30);
		quickSortLabel.setBounds(30, 150, 100, 30);
		selectionSortLabel.setBounds(30, 180, 100, 30);
		shellSortLabel.setBounds(30, 210, 100, 30);
		compareNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		moveNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		bubbleSortLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		heapSortLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		insertSortLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		quickSortLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		selectionSortLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		shellSortLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		
		sortPanel.add(compareNumberLabel);
		sortPanel.add(moveNumberLabel);

		sortPanel.add(bubbleSortLabel);

		sortPanel.add(heapSortLabel);

		sortPanel.add(insertSortLabel);
	
		sortPanel.add(quickSortLabel);
	
		sortPanel.add(selectionSortLabel);

		sortPanel.add(shellSortLabel);
		this.setLayout(new BorderLayout());
		this.add(sortPanel);
		this.setBounds((x-650)/2,(y-650)/2,450,350); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	class stratAction extends JFrame implements ActionListener
	{	
		public void actionPerformed(ActionEvent e) 
		{
			int size=0;
			String instal=JOptionPane.showInputDialog(this, "Create random numbers: ");
			
			try 
			{
				size=Integer.parseInt(instal);
			}
			catch (NumberFormatException e1)
			{
			   JOptionPane.showMessageDialog(this, "Input integer:");
			}
			
			if(size<=0)                        
			{
				JOptionPane.showMessageDialog(this, "Input positive integer");
			}
			else                              
			{
				number = size;
				thread.start();
			}
		}
	}
	
	
	
	class closeAction extends JFrame implements ActionListener
	{	
		public void actionPerformed(ActionEvent e) 
		{
			int close = JOptionPane.showConfirmDialog(this,"Quit？");
			if(close == 0)
			{
			   System.exit(0);
			}
		}
	}
	
	class showAction extends JFrame implements ActionListener
	{	
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame1 = new JFrame();
			JPanel panel1 = new JPanel();
			JTextArea jtArea = new JTextArea();
			JScrollPane scrollPane = new JScrollPane(jtArea);
			jtArea.setText(dataList.toString());
			panel1.add(scrollPane);
			frame1.add(panel1);
			frame1.setSize(500, 300);
			frame1.setLocationRelativeTo(null);
            frame1.setVisible(true);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	
	public void run() 
	{
		int list[][]= new int[5][number];
		for(int i = 0; i < 5; i++)
		{
			for (int j = 0; j < number; j++)
			{
				list[i][j] = new Integer((int)(Math.random() * 100));
			}
		}
		
		int[][] a1 = new int[5][number];
		int[][] a2 = new int[5][number];
		int[][] a3 = new int[5][number];
		int[][] a4 = new int[5][number];
		int[][] a5 = new int[5][number];
		int[][] a6 = new int[5][number];
		
		for(int i = 0; i < 5; i++)
		{
			for (int j = 0; j < number; j++)
			{
				a1[i][j] = list[i][j]; 
				a2[i][j] = list[i][j];
				a3[i][j] = list[i][j];
				a4[i][j] = list[i][j];
				a5[i][j] = list[i][j];
				a6[i][j] = list[i][j];
			}
		}
		
		this.dataList = new ArrayList<Integer>();
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < number; j++)
			this.dataList.add(a1[i][j]);
		}
		
		JTable table = new JTable(6, 2);                   
	    table.setBounds(140, 60,200, 180);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		sortPanel.add(table);
		

		BubbleSortClass bubbleSort1 = new BubbleSortClass(a1[0]);
		BubbleSortClass bubbleSort2 = new BubbleSortClass(a1[1]);
		BubbleSortClass bubbleSort3 = new BubbleSortClass(a1[2]);
		BubbleSortClass bubbleSort4 = new BubbleSortClass(a1[3]);
		BubbleSortClass bubbleSort5 = new BubbleSortClass(a1[4]);
		bubbleSort1.BubbleSort();
		bubbleSort2.BubbleSort();
		bubbleSort3.BubbleSort();
		bubbleSort4.BubbleSort();
		table.setValueAt((bubbleSort1.getCompareNumber() +
				bubbleSort2.getCompareNumber() + bubbleSort3.getCompareNumber()
				+ bubbleSort4.getCompareNumber() + bubbleSort5.getCompareNumber()) / 5, 0, 0);
		table.setValueAt((bubbleSort1.getMoveNumber() +
				bubbleSort2.getMoveNumber() + bubbleSort3.getMoveNumber()
				+ bubbleSort4.getMoveNumber() + bubbleSort5.getMoveNumber()) / 5, 0, 1);
		/*int comoareNumber1[] ={bubbleSort1.getCompareNumber(), bubbleSort2.getCompareNumber(),
				bubbleSort3.getCompareNumber(), bubbleSort4.getCompareNumber(), bubbleSort5.getCompareNumber()};
		int moveNumber1[] = {bubbleSort1.getMoveNumber(), bubbleSort2.getMoveNumber(),
				bubbleSort3.getMoveNumber(), bubbleSort4.getMoveNumber(), bubbleSort5.getMoveNumber()};
		*/
		
		
		HeapSortClass heapSort1 = new HeapSortClass(a2[0]);
		HeapSortClass heapSort2= new HeapSortClass(a2[1]);
		HeapSortClass heapSort3 = new HeapSortClass(a2[2]);
		HeapSortClass heapSort4 = new HeapSortClass(a2[3]);
		HeapSortClass heapSort5 = new HeapSortClass(a2[4]);
		table.setValueAt((heapSort1.getCompareNumber() +
				heapSort2.getCompareNumber() + heapSort3.getCompareNumber()
				+ heapSort4.getCompareNumber() + heapSort5.getCompareNumber()) / 5, 1, 0);
		table.setValueAt((heapSort1.getMoveNumber() +
				heapSort2.getMoveNumber() + heapSort3.getMoveNumber()
				+ heapSort4.getMoveNumber() + heapSort5.getMoveNumber()) / 5, 1, 1);
		/*int comoareNumber6[] ={heapSort1.getCompareNumber(), heapSort2.getCompareNumber(),
				heapSort3.getCompareNumber(), heapSort4.getCompareNumber(), heapSort5.getCompareNumber()};
		int moveNumber6[] = {heapSort1.getMoveNumber(), heapSort2.getMoveNumber(),
				heapSort3.getMoveNumber(), heapSort4.getMoveNumber(), heapSort5.getMoveNumber()};
		*/
		
	
		InsertSortClass insertSort1 = new InsertSortClass(a3[0]);
		InsertSortClass insertSort2 = new InsertSortClass(a3[1]);
		InsertSortClass insertSort3 = new InsertSortClass(a3[2]);
		InsertSortClass insertSort4 = new InsertSortClass(a3[3]);
		InsertSortClass insertSort5 = new InsertSortClass(a3[4]);
		insertSort1.insertSort();
		insertSort2.insertSort();
		insertSort3.insertSort();
		insertSort4.insertSort();
		insertSort5.insertSort();
		table.setValueAt((insertSort1.getCompareNumber() +
				insertSort2.getCompareNumber() + insertSort3.getCompareNumber()
				+ insertSort4.getCompareNumber() + insertSort5.getCompareNumber()) / 5, 2, 0);
		table.setValueAt((insertSort1.getMoveNumber() +
				insertSort2.getMoveNumber() + insertSort3.getMoveNumber()
				+ insertSort4.getMoveNumber() + insertSort5.getMoveNumber()) / 5, 2, 1);
		/* comoareNumber2[] ={insertSort1.getCompareNumber(), insertSort2.getCompareNumber(),
				insertSort3.getCompareNumber(), insertSort4.getCompareNumber(), insertSort5.getCompareNumber()};
		int moveNumber2[] = {insertSort1.getMoveNumber(), insertSort2.getMoveNumber(),
				insertSort3.getMoveNumber(), insertSort4.getMoveNumber(), insertSort5.getMoveNumber()};
		*/
	
		QuickSortClass quickSort1 = new QuickSortClass(a4[0]);
		QuickSortClass quickSort2 = new QuickSortClass(a4[1]);
		QuickSortClass quickSort3 = new QuickSortClass(a4[2]);
		QuickSortClass quickSort4 = new QuickSortClass(a4[3]);
		QuickSortClass quickSort5 = new QuickSortClass(a4[4]);
		quickSort1.quickSort();
		quickSort2.quickSort();
		quickSort3.quickSort();
		quickSort4.quickSort();
		quickSort5.quickSort();
		table.setValueAt((quickSort1.getCompareNumber() +
				quickSort2.getCompareNumber() + quickSort3.getCompareNumber()
				+ quickSort4.getCompareNumber() + quickSort5.getCompareNumber()) / 5, 3, 0);
		table.setValueAt((quickSort1.getMoveNumber() +
				quickSort2.getMoveNumber() + quickSort3.getMoveNumber()
				+ quickSort4.getMoveNumber() + quickSort5.getMoveNumber()) / 5, 3, 1);
		/*int comoareNumber3[] ={quickSort1.getCompareNumber(), quickSort2.getCompareNumber(),
				quickSort3.getCompareNumber(), quickSort4.getCompareNumber(), quickSort5.getCompareNumber()};
		int moveNumber3[] = {quickSort1.getMoveNumber(), quickSort2.getMoveNumber(),
				quickSort3.getMoveNumber(), quickSort4.getMoveNumber(), quickSort5.getMoveNumber()};
		*/
	
		SelectionSortClass selectionSort1 = new SelectionSortClass(a5[0]);
		SelectionSortClass selectionSort2 = new SelectionSortClass(a5[1]);
		SelectionSortClass selectionSort3 = new SelectionSortClass(a5[2]);
		SelectionSortClass selectionSort4 = new SelectionSortClass(a5[3]);
		SelectionSortClass selectionSort5 = new SelectionSortClass(a5[4]);
		selectionSort1.selectionSort();
		selectionSort2.selectionSort();
		selectionSort3.selectionSort();
		selectionSort4.selectionSort();
		selectionSort5.selectionSort();
		table.setValueAt((selectionSort1.getCompareNumber() +
				selectionSort2.getCompareNumber() + selectionSort3.getCompareNumber()
				+ selectionSort4.getCompareNumber() + selectionSort5.getCompareNumber()) / 5, 4, 0);
		table.setValueAt((selectionSort1.getMoveNumber() +
				selectionSort2.getMoveNumber() + selectionSort3.getMoveNumber()
				+ selectionSort4.getMoveNumber() + selectionSort5.getMoveNumber()) / 5, 4, 1);
		/*int comoareNumber4[] ={selectionSort1.getCompareNumber(), selectionSort2.getCompareNumber(),
				selectionSort3.getCompareNumber(), selectionSort4.getCompareNumber(), selectionSort5.getCompareNumber()};
		int moveNumber4[] = {selectionSort1.getMoveNumber(), selectionSort2.getMoveNumber(),
				selectionSort3.getMoveNumber(), selectionSort4.getMoveNumber(), selectionSort5.getMoveNumber()};
		*/
	
		ShellSortClass shellSort1 = new ShellSortClass(a6[0]);
		ShellSortClass shellSort2 = new ShellSortClass(a6[1]);
		ShellSortClass shellSort3 = new ShellSortClass(a6[2]);
		ShellSortClass shellSort4 = new ShellSortClass(a6[3]);
		ShellSortClass shellSort5 = new ShellSortClass(a6[4]);
		table.setValueAt((shellSort1.getCompareNumber() +
				shellSort2.getCompareNumber() + shellSort3.getCompareNumber()
				+ shellSort4.getCompareNumber() + shellSort5.getCompareNumber()) / 5, 5, 0);
		table.setValueAt((shellSort1.getMoveNumber() +
				shellSort2.getMoveNumber() + shellSort3.getMoveNumber()
				+ shellSort4.getMoveNumber() + shellSort5.getMoveNumber()) / 5, 5, 1);
		/*int comoareNumber5[] ={shellSort1.getCompareNumber(), shellSort2.getCompareNumber(),
				shellSort3.getCompareNumber(), shellSort4.getCompareNumber(), shellSort5.getCompareNumber()};
		int moveNumber5[] = {shellSort1.getMoveNumber(), shellSort2.getMoveNumber(),
				shellSort3.getMoveNumber(), shellSort4.getMoveNumber(), shellSort5.getMoveNumber()};
				*/
	}
	
	public static void main(String[] args)
	{
		new MainWindows();
	}
}
