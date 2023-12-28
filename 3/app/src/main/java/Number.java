public class Number {
    int number;
    int row;
    int begin;
    int end;

    public Number(String number, int row, int begin, int end) {
        this.number = Integer.parseInt(number);
        this.row = row;
        this.begin = begin;
        this.end = end;
    }

    public int include(ArrayList<ArrayList<Integer>> symbols) {
        return 0;
    }
}
