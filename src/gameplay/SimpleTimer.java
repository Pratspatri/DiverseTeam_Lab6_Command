package gameplay;

import java.util.ArrayList;

/**
 * This class consists members and functions related to SimpleTimer. SimpleTimer
 * is a Timer.
 * @author : Sameer Kumar Kotra
 */
public class SimpleTimer extends Thread implements Timer
{

	/**
	 * int to keep track of the round.
	 */
	private int round;

	/**
	 * List of Observers.
	 */
	private ArrayList<TimeObserver> theObservers;

	/**
	 * int to store sleep time.
	 */
	private int sleepTime;

	/**
	 * Create an instance of SimpleTimer.
	 */
	public SimpleTimer()
	{
		round = 0;
		theObservers = new ArrayList<TimeObserver>();
	}

	/**
	 * Create an instance of SimpleTimer with give time.
	 * @param time : the time taken for one round.
	 */
	public SimpleTimer(int time)
	{
		this();
		sleepTime = time;
	}

	/**
	 * Adds the observer to the list ,to which it notifies when time changed.
	 * @param observer : The observer to be added.
	 */
	@Override
	public void addTimeObserver(TimeObserver observer)
	{
		theObservers.add(observer);
	}

	/**
	 * Removes the observer from the observer list.
	 * @param observer : The observer which is to be removed.
	 */
	@Override
	public void removeTimeObserver(TimeObserver observer)
	{
		theObservers.remove(observer);
	}

	/**
	 * The method updates all the observers about the change in time.
	 */
	@Override
	public void timeChanged()
	{
		for (TimeObserver to : theObservers)
		{
			to.updateTime(round);
		}
	}

	/**
	 * @return the present round of the game.
	 */
	public int getRound()
	{
		return round;
	}

	/**
	 * @return the clone of the observerList.
	 */
	public ArrayList<TimeObserver> getTheObservers()
	{
		return new ArrayList<TimeObserver>(theObservers);
	}

	/**
	 * Update the round.
	 */
	public void updateRound()
	{
		round++;
	}

	/**
	 * Updates time for each second and calls the time changed.
	 */
	@Override
	public void run()
	{
		for (int i = 0; i < 50; i++)
		{
			try
			{
				Thread.sleep(sleepTime);
				updateRound();
				timeChanged();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
