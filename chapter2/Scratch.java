package chapter2;

import java.util.function.Predicate;

public class Scratch
{
	private static class Daemon
	{
		public boolean isRunning()
		{
			return false;
		}
	}
	
	// A predicate on Daemons to tell if they're running. We could have many of these
	// to check various Daemon conditions, meaning we only need the one static method
	// below in order to have behaviour that waits until these conditions are true.
	public static final Predicate<Daemon> isStopped = jd -> !jd.isRunning();
	// A general purpose predicate that determines if a timer has expired given
	// the starting time.
	public static final Predicate<Long> timeoutExpired = ( start ) -> ( System.currentTimeMillis() - start ) > 10000;
	
	public static void loopUntilDaemonPredicateIsTrue( Daemon daemon, Predicate<Daemon> predicate )
	{
		long start = System.currentTimeMillis();
		while( !timeoutExpired.test( start ) && !predicate.test( daemon ) );
		System.out.println( "Predicate is now true!!!" );
	}

	public static void main( String[] args )
	{
		Daemon daemon = new Daemon();
		loopUntilDaemonPredicateIsTrue( daemon, isStopped );
	}
}
