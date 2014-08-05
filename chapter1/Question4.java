package chapter1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Question4 {

	public static void main(String[] args) throws IOException {
		File[] files = new File("/Users/ruarc").listFiles();
		printFiles(files);
		sortFiles(files);
		System.out.println("\n...after sorting:\n");
		printFiles(files);
	}

	private static void printFiles(File[] files) throws IOException {
		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	private static void sortFiles(File[] files) {
		Arrays.sort(files, (file1, file2) -> {
			boolean file1isDirectory = file1.isDirectory();
			boolean file2isDirectory = file2.isDirectory();
			if (file1isDirectory == file2isDirectory) {
				return file1.getName().compareTo(file2.getName());
			} else {
				return (file2isDirectory ? 1 : 0) - (file1isDirectory ? 1 : 0);
			}
		});
	}
}
