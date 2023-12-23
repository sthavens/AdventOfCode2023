import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {
        File file = new File("/home/sthavens/advent/1/app/src/main/java/source1.txt");
        final Trie trie = new Trie();
        try{
            Scanner scanner = new Scanner(file);

            int sum = 0;

            Map<String, String> nums = Stream.of(new String[][] {
                {"one", "1"},
                {"two", "2"},
                {"three", "3"},
                {"four", "4"},
                {"five", "5"},
                {"six", "6"},
                {"seven", "7"},
                {"eight", "8"},
                {"nine", "9"},
                {"1", "1"},
                {"2", "2"},
                {"3", "3"},
                {"4", "4"},
                {"5", "5"},
                {"6", "6"},
                {"7", "7"},
                {"8", "8"},
                {"9", "9"}
            }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

            for (String i: nums.keySet()) {
                trie.add(i, nums.get(i));
            }

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // for (Map.Entry<String, String> entry : nums.entrySet()) {
                //     line = line.replaceAll(entry.getKey(), entry.getValue());
                // }
                // System.out.println(line);
                // char first = ' ';
                // char last = ' ';
                // for (int i = 0; i < line.length(); i++) {
                //     char test = line.charAt(i);
                //     if (test > 47 && test < 58) {
                //         first = test;
                //         break;
                //     }
                // }
                // for (int i = line.length() - 1; i >= 0 ; i--) {
                //     char test = line.charAt(i);
                //     if (test > 47 && test < 58) {
                //         last = test;
                //         break;
                //     }
                // }
                ArrayList<Integer> numbers = new ArrayList<>();

                for (int i = 0; i < line.length(); i++) {
                    Optional<String> number = trie.search(line.substring(i));
                    if (number.isPresent()) {
                        numbers.add(Integer.parseInt(number.get()));
                    }
                }

                int number = (numbers.get(0) * 10) + numbers.get(numbers.size() - 1);
                sum += number;
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
