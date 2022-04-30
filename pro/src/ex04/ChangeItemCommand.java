package ex04;

import ex01.Item2d;

/** Команда
 * Change item;
 * шаблон Command
 * @author Illia_Shpachynsky
 * @version 1.0
 */

public class ChangeItemCommand implements Command {
	/** Оброблений об'єкт; шаблон Command */
	private Item2d item;
	
	/** Параметр команди; шаблон Command */
	private int offset;
	
	/** Встановлює поле {@linkplain ChangeItemCommand#item}
	 * @param item значення для {@linkplain ChangeItemCommand#item}
	 * @return нове значення {@linkplain ChangeItemCommand#item}
	 */
	public Item2d setItem(Item2d item) {
		return this.item = item;
	}
	
	/** Повертає поле {@linkplain ChangeItemCommand#item}
	 * @return значення {@linkplain ChangeItemCommand#item}
	 */
	public Item2d getItem() {
		return item;
	}
	
	/** Встановлює поле поле {@linkplain ChangeItemCommand#offset}
	 * @param offset значення для {@linkplain ChangeItemCommand#offset}
	 * @return нове значення {@linkplain ChangeItemCommand#offset}
	 */
	public int setOffset(int offset) {
		return this.offset = offset;
	}
	
	/** Повертає поле {@linkplain ChangeItemCommand#offset}
	 * @return значення {@linkplain ChangeItemCommand#offset}
	 */
	public int getOffset() {
		return offset;
	}
	
	@Override
	public void execute() {
		int x =item.getX()*offset;
		 String []result = {Integer.toBinaryString(x),Integer.toOctalString(x),Integer.toHexString(x)};
		
		item.setY(result);
	}
}