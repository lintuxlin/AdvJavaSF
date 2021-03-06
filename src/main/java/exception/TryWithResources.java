package exception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class MyException extends Exception {}
class MyOtherException extends Exception {}
class MyThirdException extends Exception {}

public class TryWithResources {

	public void doStuff() throws MyOtherException, MyThirdException {
		try (BufferedReader input = Files.newBufferedReader(Paths.get("input.txt"));
			 BufferedWriter output = Files.newBufferedWriter(Paths.get("output.txt"))) {
			if (Math.random() > 0.5) {
				throw new MyOtherException();
			}
			if (Math.random() > 0.5) {
				throw new MyThirdException();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyOtherException | MyThirdException ex) {
			// ex is type Exceptin
			ex.printStackTrace();
			throw ex;
		}
		// finally block that closes all stream is autocreated
		finally { // rarely needed with try-with-resources syntax
			// executed AFTER autogenerated finally
			System.out.println("additional finally work");
		}
	}
	
	public static void main(String[] args) {

	}

}
