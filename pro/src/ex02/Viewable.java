package ex02;

/** Creator
 * (шаблон проектування
 * Factory Method)<br>
 * Об'являє метод,
 * "фабрикуючі" об'єкти
 * @author Illia_Shpachynsky
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable 
{
	/** Створює об'єкт, реалізуючий {@linkplain View} 
	 *@return - збережені дані
	 */
	public View getView();
}