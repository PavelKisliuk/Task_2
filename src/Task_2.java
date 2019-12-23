import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Task_2 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		Summer test = new Summer(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Summer {
	private int number;

	public Summer(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String data = input.lines().collect(Collectors.joining());
			number = Integer.parseInt(data);
		} catch (IOException e) {
			number = 0;
		}
	}

	private int sum() {
		if(number == 0) {
			return 1;
		}

		int sum = 0;
		int pace = number / Math.abs(number);
		do {
			sum += number;
			number -= pace;
		} while (number != 1);
		return ++sum;
	}

	@Override
	public String toString() {
		return String.valueOf(sum());
	}
}