package ex03;

import ex02.View;

/** ���������� � ����������� ����������<br>
* ������ ��������� ���������� ������ main()
* @author Illia_Shpachynsky
* @version 3.0
* @see Main#main
*/

public class Main extends ex02.Main 
{
	/** ��������� ���� {@linkplain ex02.Main#view view} */
	public Main(View view) 	
	{
		super(view);

	}
	/** ���������� ��� ������� ��������;
	 * ������� ����� {@linkplain ex02.Main#menu menu()}
	 * @param args - ��������� ������� ��������
	 */
	
	public static void main(String[] args) 
	{
		Main main = new Main(new ViewableTable().getView());
		main.menu();
	}
}