package ex04;

/** ���������
 * ��������� �������;
 * ������ Command
 * @author Illia_Shpachynsky
 * @version 1.0
 */
public interface ConsoleCommand extends Command {
	/** ������ ������ �������;
	 * ������ Command
	 * @return ������ ������ ������
	 */
	public char getKey();
}