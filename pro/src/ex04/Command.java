package ex04;

/** ��������� �������
 * ��� ������;
 * �������: Command,
 * Worker Thread
 * @author Illia_Shpachynsky
 * @version 1.0
 */

public interface Command {
	/** ������ �������; �������: Command, Worker Thread */
	public void execute();
}