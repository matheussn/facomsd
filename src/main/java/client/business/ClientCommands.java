package client.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import client.commons.domain.Method;
import client.commons.exceptions.DomainException;
import client.commons.exceptions.ErrorMap;
import client.commons.utils.CommandUtils;
import client.commons.validation.utils.InputRequestValidator;

public class ClientCommands implements Runnable {

	private PrintStream output;
	private Scanner scanner;
	private boolean isTest;
	private String filePath;

	public ClientCommands(PrintStream output, boolean isTest, String filePath) {
		this.output = output;
		this.scanner = new Scanner(System.in);
		this.isTest = isTest;
		this.filePath = filePath;
	}

	@Override
	public void run() {
		BufferedReader reader = getFileIfMeantForTest();
		for (;;) {
			String userInput = isTest ? getInputFromFile(reader) : getInputFromKeyboard();
			try {
				if (CommandUtils.getMethodByUserInput(userInput).equals(Method.SAIR)) {
					break;
				}
				InputRequestValidator.validateInput(userInput);
				UserProcessor.sendCommand(userInput, this.output);
			} catch (DomainException e) {
				System.err.println(e.getErrorMessage());
			} catch (Exception e) {
				System.err.println(ErrorMap.UNEXPECTED_ERROR.getMessage());
			}
		}
		System.out.println("Finalizando thread de Comandos...");
	}

	private void printCommands() {
		System.out.println("Comandos: ");
		System.out.println("create, get, update e delete");
		System.out.println("Caso queira sair, digite 'sair'");
	}
	
	private BufferedReader getFileIfMeantForTest() {
		if (isTest && !StringUtils.isEmpty(filePath)) {
			try {
				return new BufferedReader(new FileReader(new File(filePath)));
			} catch (FileNotFoundException e) {
				return null;
			}
		}
		return null;
	}
	
	private String getInputFromKeyboard() {
		printCommands();
		return CommandUtils.modelateRequest(scanner.nextLine());
	}
	
	private String getInputFromFile(BufferedReader reader) {
		try {
			if (reader != null && reader.ready()) {
				return reader.readLine();
			} else {
				return "sair";
			}
		} catch (IOException e1) {
			return null;
		}
	}
}