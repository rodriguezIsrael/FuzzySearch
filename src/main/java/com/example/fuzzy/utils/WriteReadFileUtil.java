package com.example.fuzzy.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WriteReadFileUtil {

	private static final String FILE_NAME = "../fuzzy/src/main/java/com/example/fuzzy/fuzzy-search.txt";
	private static final String FILE_NAME_C = "C:/fuzzy-search.txt";

	public static boolean write(String text) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
			StringBuilder sb = new StringBuilder();
			sb.append(text);
			sb.append("\r\n");
			writer.write(sb.toString());
			writer.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	
	}



	public static List<String> read() {
		List<String> list = new ArrayList<String>();

		try {

			BufferedReader br = Files.newBufferedReader(Paths.get(FILE_NAME_C));

			list = br.lines().collect(Collectors.toList());

		} catch (NoSuchFileException ex) {
			try {

				BufferedReader br = Files.newBufferedReader(Paths.get(FILE_NAME));

				list = br.lines().collect(Collectors.toList());

			} catch (NoSuchFileException exs) {
				System.out.println(
						"Por favor coloca el archivo [fuzzy-search.txt] en C:/ junto con el jar [Aplicacion.jar]");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (

		IOException e) {

		}

		return list;
	}
}
