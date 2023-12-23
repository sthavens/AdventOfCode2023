import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("/home/seyd/advent/4/app/src/main/java/input.txt"));

        String pattern = "(?:(\\d+)\\s*)+?";
        Pattern compiled = Pattern.compile(pattern);

        int sum = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.split(":")[1].strip();
            String winning = line.split("\\|")[0].strip();
            // String[] test = winning.split("\s{1,2}?");
            Matcher matcher = compiled.matcher(winning);
            int[] winningNumbers = matcher.results().map(match -> match.group(1)).mapToInt(Integer::parseInt).toArray();
            String numbers = line.split("\\|")[1].strip();
            int[] potentialWinners = compiled.matcher(numbers).results().map(match -> match.group(1)).mapToInt(Integer::parseInt).toArray();
            // long wins = Arrays.stream(potentialWinners).filter(number -> Arrays.asList(winningNumbers).contains(number)).count();
            // System.out.println(wins);
            int count = 0;
            for (int i: potentialWinners) {
                if (Arrays.stream(winningNumbers).boxed().collect(Collectors.toList()).contains(i)) {
                    count += 1;
                }
            }
            sum += Math.pow(2, count - 1);
            System.out.println(sum);
        }
    }
}
