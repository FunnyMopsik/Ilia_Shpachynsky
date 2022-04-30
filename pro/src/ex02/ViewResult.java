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
 * (Шаблон проектування
 * Factory Method)<br>
 * Обчислювальні функції,
 * зберігає і відображає
 * результати
 * @author Illia_Shpachynsky
 * @version 1.0
 * @see View
 */
public class ViewResult implements View 
{
	
	/** Ім'я файлу, використовуюче при серіалізації */
	private static final String FNAME = "items.bin";
	
	/** Оприділяє кількість значень для обчислень за вмовчуванням */
	private static final int DEFAULT_NUM = 10;
	
	/** Колекція аргументів і результатів обчислень */
	private ArrayList<Item2d> items = new ArrayList<Item2d>();
	
	/** Визиває {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 * з параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() 
	{
		this(DEFAULT_NUM);
		}
	
	/** Ініціалізує колекцію {@linkplain ViewResult#items}
	 * @param n початкова кількість елементів
	 */
	public ViewResult(int n) 
	{
		for(int ctr = 0; ctr < n; ctr++) 
		{
			items.add(new Item2d());
		}
	}
	
	/** Отримує значення {@linkplain ViewResult#items}
	 * @return поточне значення посилання на об'єкт {@linkplain ArrayList}
	 */
	public ArrayList<Item2d> getItems() 
	{
		return items;
	}
	
	/** Обчислює значення функції
	* @param x аргумент обчислюваної функції
	* @return результат обчислень функції
	*/
	private String [] calc(int x) 
	{
		String []result = {Integer.toBinaryString(x),Integer.toOctalString(x),Integer.toHexString(x)};
        
        
		return result;
	}
	
	/** Вычисляет значение функции и сохраняет
	 * результат в коллекции {@linkplain ViewResult#items}
	 * @param stepX шаг приращения аргумента
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
	
	/** Викликає <b>init(double stepX)</b> з випадковими значеннями аргументу<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewInit() 
	{
		Random random = new Random();
		init(random.ints(0, 360).findFirst().getAsInt());
	}
	
	/** Реалізація методу {@linkplain View#viewSave()}<br>
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
	
	/** Реалізація методу {@linkplain View#viewRestore()}<br>
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
	
	/** Реалізація методу {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() 
	{
		System.out.println("Results:");
	}
	
	/** Реалізація методу {@linkplain View#viewBody()}<br>
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
	
	/** Реалізація методу {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() 
	{
		System.out.println("End.");
	}
	
	/** Реалізація методу {@linkplain View#viewShow()}<br>
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