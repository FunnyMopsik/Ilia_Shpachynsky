package ex03;

import java.util.Formatter;
import ex01.Item2d;
import ex02.ViewResult;

/** ConcreteProduct
 * (шаблон проектування
 * Factory Method)<br>
 * Вивід в вигляді таблиці
 * @author Illia_Shpachynsky
 * @version 1.0
 * @see ViewResult
 */

public class ViewTable extends ViewResult 
{
	/** Встановлює ширину таблиці за вмовчуванням*/
	private static final int DEFAULT_WIDTH = 55;
	
	/** Поточна ширина таблиці */
	private int width;
	
	/** Встановлює {@linkplain ViewTable#width width}
	 * значенням {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
	 * Викликається конструктор суперкласу {@linkplain ViewResult#ViewResult() ViewResult()}
	 */
	public ViewTable() 
	{
		width = DEFAULT_WIDTH;
	}
	
	/** Встановлюється {@linkplain ViewTable#width} значенням <b>width</b><br>
	 * Викликається конструктор суперкласу {@linkplain ViewResult#ViewResult() ViewResult()}
	 * @param width визначає ширину таблиці
	 */
	public ViewTable(int width) 
	{
		this.width = width;
	}
	
	/** Встановлює {@linkplain ViewTable#width} значенням <b>width</b><br>
	 * Викликається конструктор суперкласу {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 * @param width визначає ширину таблиці
	 * @param n кількість елементів колекції; передається суперконструктору
	 */
	public ViewTable(int width, int n) 
	{
		super(n);
		this.width = width;
	}
	
	/** Встановлює поле {@linkplain ViewTable#width} значенням <b>width</b>
	 * @param width нова ширина таблиці
	 * @return задана параметром <b>width</b> ширина таблиці
	 */
	public int setWidth(int width) 
	{
		return this.width = width;
	}
	
	/** Повертає значення поля {@linkplain ViewTable#width}
	 * @return поточна ширина таблиці
	 */
	public int getWidth() 
	{
		return width;
	}
	
	/** Виводить вертикальну лінію розподілу шириною {@linkplain ViewTable#width} символів */
	private void outLine() 
	{
		for(int i = width; i > 0; i--) 
		{
			System.out.print('-');
		}
	}
	
	/** Викликає {@linkplain ViewTable#outLine()}; завершує вивід лінії розподілу */
	private void outLineLn() 
	{
		outLine();
		System.out.println();
	}
	
	/** Виводить заголовок таблиці шириною {@linkplain ViewTable#width} символів */
	private void outHeader() 
	{
		
		Formatter fmt = new Formatter();
		fmt.format("%s%d%s%2$d%s", "%", 5, "s | %", "s\n");
		System.out.printf(fmt.toString(), "x ", "y ");
	}
	
	/** Виводить тіло таблиці шириною {@linkplain ViewTable#width} символів */
	private void outBody() 
	{
		
	 Formatter fmt = new Formatter();
	 fmt.format("%s%d%s%2$d%s", "%", 5, "s | %", "s\n");
	 for(Item2d item : getItems())
		{	
			String []y = item.getY();
			String text = "y: 2 -> "+y[0]+"; 8 -> "+y[1]+"; 16 -> "+y[2];
			System.out.printf(fmt.toString(), item.getX(),text);
			
			
		}
	}
	
	/** Перезавантаження (заміщення, overloading) метода суперкласу;
	 * встановлює поле {@linkplain ViewTable#width} значенням <b>width</b><br>
	 * Викликає метод {@linkplain ViewResult#viewInit() viewInit()}
	 * @param width нова ширина таблиці
	*/
	public final void init(int width) 
	{ // method overloading
		this.width = width;
		viewInit();
	}
	
	/** Перезавантаження метода суперкласу;
	 * Встановлює поле {@linkplain ViewTable#width} значенням <b>width</b><br>
	 * Для об'єкта {@linkplain ViewTable} викликає метод  {@linkplain ViewTable#init(int
	 stepX)}
	 * @param width нова ширина таблиці.
	 * @param stepX передаєтся методу <b>init(int)</b>
	 */
	public final void init(int width, double stepX) 
	{ // method overloading
		this.width = width;
		init(stepX);
	}
	
	/** Перерозподіл (заміщення, overriding) методу суперкласу;
	 * виводить інформаційне повідомлення і викликає метод суперкласу
	 * {@linkplain ViewResult#init(int stepX) init(int stepX)}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void init(double stepX) 
	{ // method overriding
		System.out.print("Initialization... ");
		super.init(stepX);
		System.out.println("done. ");
	}
	
	/** Вивід елемента таблиці<br>{@inheritDoc} */
	@Override
	public void viewHeader() 
	{
		outHeader();
		outLineLn();
	}
	
	/** Вивід елемента таблиці<br>{@inheritDoc} */
	@Override
	public void viewBody() 
	{
		outBody();
	}
	
	/** Вивід елемента таблиці<br>{@inheritDoc} */
	@Override
	public void viewFooter() {
		outLineLn();
	}
}