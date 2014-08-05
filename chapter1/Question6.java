package chapter1;

public class Question6 {

	public static void main( String[] args ) {
		new Thread( uncheck( () -> {
			System.out.println( "Zzz");
			Thread.sleep( 1000 ); } ) ).start();
	}
	
	/*
	 * Map from a RunnableEx to a Runnable.
	 */
	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception ex) {
				System.err.println("An exception was thrown!");
			};
		};
	}
	
	interface RunnableEx {
		public void run() throws Exception;
	}
}
