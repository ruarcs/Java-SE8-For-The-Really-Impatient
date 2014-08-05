package chapter1;

import java.io.File;
import java.io.IOException;

public class Question2 {
	
	public static void main( String[] args ) throws IOException {
		Question2 q = new Question2();
		for( File file : q.subDirectories( new File( "." ) ) ) {
			System.out.println( file.getCanonicalPath() );
		}
	}
	
	private File[] subDirectories( File file ) {
		return file.listFiles( File::isDirectory );
	}
}
