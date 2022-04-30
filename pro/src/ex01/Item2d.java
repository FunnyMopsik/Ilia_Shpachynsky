package ex01;

import java.io.Serializable;

/**
 * ������ ������ ���� �� ��������� ��������� ������.
 * 
 * @author Illia_Shpachynsky
 * @version 1.0
 */

public class Item2d implements Serializable 
{

	/** �������� ������������� �������. */
	// transient
	private int x;

	/** ��������� ���������� �������. */
	private String []y = new String [3];

	/** ����������� ����������� ��������� */
	private static final long serialVersionUID = 1L;

	/** �������� ���� {@linkplain Item2d#x}, {@linkplain Item2d#y} */
	public Item2d()
	{
		x = 0;
		for(int i=0; i<3;i++) 
		{
			y[i]="0";
		}
	}

	/**
	 * ���������� �������� �����: ��������� � ���������� ���������� �������.
	 * 
	 * @param x - �������� ��� ����������� ���� {@linkplain Item2d#x}
	 * @param y - �������� ��� ����������� ���� {@linkplain Item2d#y}
	 */
	public Item2d(int x, String []y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * ������������ �������� ���� {@linkplain Item2d#x}
	 * 
	 * @param x - �������� ��� {@linkplain Item2d#x}
	 * @return �������� {@linkplain Item2d#x}
	 */
	public int setX(int x)
	{
		return this.x = x;
	}

	/**
	 * ��������� �������� ���� {@linkplain Item2d#x}
	 * 
	 * @return �������� {@linkplain Item2d#x}
	 */
	public int getX() 
	{
		return x;
	}

	/**
	 * ������������ �������� ���� {@linkplain Item2d#y}
	 * 
	 * @param strings - �������� ��� {@linkplain Item2d#y}
	 * @return �������� {@linkplain Item2d#y}
	 */
	public String[] setY(String[] strings)
	{
		return this.y = strings;
	}

	/**
	 * ��������� �������� ���� {@linkplain Item2d#y}
	 * 
	 * @return �������� {@linkplain Item2d#y}
	 */
	public String[] getY()
	{
		return y;
	}

	/**
	 * ������������ �������� {@linkplain Item2d#x} � {@linkplain Item2d#y}
	 * 
	 * @param x - �������� ��� {@linkplain Item2d#x}
	 * @param y - �������� ��� {@linkplain Item2d#y}
	 * @return this
	 */
	public Item2d setXY(int x, String []y) 
	{
		this.x = x;
		this.y = y;
		return this;
	}

	/**
	 * ����������� ��������� ���������� � ������ �����.<br>
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		String text = "x= "+x+"\n";
		text = text+"y: 2 -> "+y[0]+"; 8 -> "+y[1]+"; 16 -> "+y[2];
		
		return text;
	}

	/**
	 * ����������� ������������ �����.<br>
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item2d other = (Item2d) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		
		return true;
	}
}