package com.example.fuzzy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.fuzzy.facade.CMDFacade;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		String EXIT = "EXIT";
//		System.out.println("[Configuracion]:Por favor coloca este jar y el archivo [fuzzy-search.txt] sobre C:\\");

		System.out.println("===== Aplicación iniciada: Ejecuta comandos de tipo ADD,LIST,SEARCH, Para salir escribe (exit) ===== ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		String command = reader.readLine();
		CMDFacade cmd = new CMDFacade();
		while (!EXIT.equals(command.toUpperCase())) {
		
			cmd.exec(command);
			command = reader.readLine();
		}

	}
}
