package gameplay;

/**
 * This Interface contains the methods declarations related to TimerObserver.
 * @author : Sameer Kumar Kotra
 */
public interface TimeObserver
{
	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * @param time : updated time
	 */
	public void updateTime(int time);
}
