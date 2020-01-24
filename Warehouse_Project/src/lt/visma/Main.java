package lt.visma;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		 Scanner reader = new Scanner(System.in);
		AdminConsole a =new AdminConsole(reader);
		a.start();

	}

}
