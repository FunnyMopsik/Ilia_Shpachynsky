package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import ex01.Item2d;

/** ConcreteProduct
 * (������ ������������
 * Factory Method)<br>
 * ������������� �������,
 * ������ � ��������
 * ����������
 * @author Illia_Shpachynsky
 * @version 1.0
 * @see View
 */
public class ViewResult implements View 
{
	
	/** ��'� �����, �������������� ��� ���������� */
	private static final String FNAME = "items.bin";
	
	/** �������� ������� ������� ��� ��������� �� ������������ */
	private static final int DEFAULT_NUM = 10;
	
	/** �������� ��������� � ���������� ��������� */
	private ArrayList<Item2d> items = new ArrayList<Item2d>();
	
	/** ������ {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 * � ���������� {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() 
	{
		this(DEFAULT_NUM);
		}
	
	/** ��������� �������� {@linkplain ViewResult#items}
	 * @param n ��������� ������� ��������
	 */
	public ViewResult(int n) 
	{
		for(int ctr = 0; ctr < n; ctr++) 
		{
			items.add(new Item2d());
		}
	}
	
	/** ������ �������� {@linkplain ViewResult#items}
	 * @return ������� �������� ��������� �� ��'��� {@linkplain ArrayList}
	 */
	public ArrayList<Item2d> getItems() 
	{
		return items;
	}
	
	/** �������� �������� �������
	* @param x �������� ����������� �������
	* @return ��������� ��������� �������
	*/
	private String [] calc(int x) 
	{
		String []result = {Integer.toBinaryString(x),Integer.toOctalString(x),Integer.toHexString(x)};
        
        
		return result;
	}
	
	/** ��������� �������� ������� � ���������
	 * ��������� � ��������� {@linkplain ViewResult#items}
	 * @param stepX ��� ���������� ���������
	 */
	public void init(double stepX) 
	{
		int x = 0;
		for(Item2d item : items) 
		{
			item.setXY(x, calc(x));
			x += stepX;
		}
	}
	
	/** ������� <b>init(double stepX)</b> � ����������� ���������� ���������<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewInit() 
	{
		Random random = new Random();
		init(random.ints(0, 360).findFirst().getAsInt());
	}
	
	/** ��������� ������ {@linkplain View#viewSave()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewSave() throws IOException 
	{
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(items);
		os.flush();
		os.close();
	}
	
	/** ��������� ������ {@linkplain View#viewRestore()}<br>
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void viewRestore() throws Exception 
	{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		items = (ArrayList<Item2d>) is.readObject();
		is.close();
	}
	
	/** ��������� ������ {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() 
	{
		System.out.println("Results:");
	}
	
	/** ��������� ������ {@linkplain View#viewBody()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewBody() 
	{
		for(Item2d item : items)
		{
			String text = "[ x= "+item.getX();
			String []y = item.getY();
			text = text+"; y: 2 -> "+y[0]+"; 8 -> "+y[1]+"; 16 -> "+y[2]+"]";
			
			System.out.print(text+"\n");
			
			
		}
		System.out.println();
	}
	
	/** ��������� ������ {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() 
	{
		System.out.println("End.");
	}
	
	/** ��������� ������ {@linkplain View#viewShow()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewShow() 
	{
		viewHeader();
		viewBody();
		viewFooter();
	}
}