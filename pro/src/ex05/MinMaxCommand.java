package ex05;

import java.util.concurrent.TimeUnit;
import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;
import java.util.stream.*;


/** Задача, використовується 
 * розробником потоку;
 * шаблон Worker Thread
 * @author Illia_Shpachynsky
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class MinMaxCommand implements Command /*, Runnable */ {
	
	/** Зберігає результат обробки колекції */
	private int resultMin = -1;
	
	/** Зберігає результат обробки колекції */
	private int resultMax = -1;
	
	/** Прапорець готовності результату */
	private int progress = 0;
	
	/** Обслуговує колекцію об'єктів {@linkplain ex01.Item2d} */
	private ViewResult viewResult;
	
	/** повертає поле {@linkplain MinMaxCommand#viewResult}
	 * @return значення {@linkplain MinMaxCommand#viewResult}
	 */
	public ViewResult getViewResult() {
		return viewResult;
	}
	
	/** Встановлює поле {@linkplain MinMaxCommand#viewResult}
	 * @param viewResult значення для {@linkplain MinMaxCommand#viewResult}
	 * @return нове значення {@linkplain MinMaxCommand#viewResult}
	 */
	public ViewResult setViewResult(ViewResult viewResult) {
		return this.viewResult = viewResult;
	}
	
	/** Ініціалізує поле {@linkplain MinMaxCommand#viewResult}
	 * @param viewResult об'єкт класу {@linkplain ViewResult}
	 */
	public MinMaxCommand(ViewResult viewResult) {
		this.viewResult = viewResult;
	}
	
	/** Повертає результат
	 * @return поле {@linkplain MinMaxCommand#resultMin}
	 */
	public int getResultMin() {
		return resultMin;
	}
	
	/** Повертає результат
	 * @return поле {@linkplain MinMaxCommand#resultMax}
	 */
	public int getResultMax() {
		return resultMax;
	}
	
	/** Перевіряє готовність результату
	 * @return false - якщо результат знайдений, інакше - true
	 */
	public boolean running() {
		return progress < 100;
	}
	
	/** Використовується обробником потоку {@linkplain CommandQueue};
	 * шаблон Worker Thread
	 */
	@Override
	public void execute() {
		progress = 0;
		System.out.println("MinMax executed...");
		int idx = 0, size = viewResult.getItems().size();
		for (Item2d item : viewResult.getItems()) {
			if (item.getX() < 0) {
				if (resultMax == -1)
								 {
					resultMax = idx;
				}
			} else {
				if (resultMin == -1 ) {
					resultMin = idx;
				}
			}
			idx++;
			progress = idx * 100 / size;
			if (idx % (size / 5) == 0) {
				System.out.println("MinMax " + progress + "%");
			}
			try {
				TimeUnit.MILLISECONDS.sleep(5000 / size);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		System.out.print("MinMax done. ");
		if (resultMin > -1) {
			
			String text = "[ x= "+viewResult.getItems().get(resultMin).getX();
			String []y = viewResult.getItems().get(resultMin).getY();
			text = text+"; y: 2 -> "+y[0]+"; 8 -> "+y[1]+"; 16 -> "+y[2]+"]";
			
			System.out.print(text+"\n");
			System.out.print("Min positive #" + resultMin + " found: " +
					
					String.format("%s",
							text));
		} else {
			System.out.print("Min positive not found.");
		}
		if (resultMax > -1) {
			System.out.println(" Max negative #" + resultMax + " found: " +
					String.format("%.2f.",
							viewResult.getItems().get(resultMax).getY()));
		} else {
			System.out.println(" Max negative item not found.");
		}
		progress = 100;
	}
	
	/**
	@Override
	public void run() {
		execute();
	}
	/**/
}