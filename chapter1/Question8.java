package chapter1;

import java.util.ArrayList;
import java.util.List;

public class Question8 {
	public static void main( String[] args ) {
		String[] names = {
				"Peter", "Paul", "Mary"
		};
		List<Runnable> runners = new ArrayList<>();
		for( String name : names ) {
			runners.add( () -> System.out.println( name ) );
		}
		for( Runnable r : runners ) {
			r.run();
		}
	}
}
