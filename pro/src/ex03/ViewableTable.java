package ex03;

import ex02.ViewableResult;
import ex02.View;

/** ConcreteCreator
 * (шаблон проектування
 * Factory Method)<br>
 * Об'являє метод,
 * "фабрикуючі" об'єкти
 * @author Illia_Shpachynsky
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
 */

public class ViewableTable extends ViewableResult 
{
	/** Створює відображаємий об'єкт {@linkplain ViewTable} */
	@Override
	public View getView() 
	{
		return new ViewTable();
	}
}