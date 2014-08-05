package chapter1;

public class Question7 {
	public static void main( String[] args ) {
		Runnable runnable = andThen( () -> System.out.println( "1!!!!" ),
				                     () -> System.out.println( "2!!!!" ) );
		runnable.run();
	}
	
	public static Runnable andThen( Runnable runnable1, Runnable runnable2 ) {
		return () -> {
			runnable1.run();
			runnable2.run();
		};
	}
}
