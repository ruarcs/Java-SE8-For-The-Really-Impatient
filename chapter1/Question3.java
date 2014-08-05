package chapter1;

import java.io.File;
import java.io.IOException;

public class Question3 {
	private static final String TEST_DIR = "/Users/ruarc/Documents/workspace/Test/src/com/example/test";

	public static void main(String[] args) throws IOException {
		Question3 q = new Question3();
		for (File file : q.filesWithExtension(new File(TEST_DIR), ".java")) {
			System.out.println(file.getCanonicalPath());
		}
	}

	private File[] filesWithExtension(File file, String extension) throws IOException {
		return file.listFiles((f, name) -> name.endsWith(extension));
	}
}
