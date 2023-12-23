import java.util.ArrayList;

public class Node {
    char info;
        ArrayList<Node> children = new ArrayList<>();
        boolean isEndOfWord;
        String returnChar;

        public Node() {
            this.children = new ArrayList<>();
            this.isEndOfWord = false;
        }

        public Node(char info) {
            this();
            this.info = info;
        }

        public Node(char info, String returnChar) {
            this(info);
            this.isEndOfWord = true;
            this.returnChar = returnChar;
        }

        public boolean contains(char toSearch) {
            for(Node child: this.children) {
                if(child.info == toSearch) {
                    return true;
                }
            }
            return false;
        }

        public Node get(char toGet) {
            for (Node child: this.children) {
                if (child.info == toGet) {
                    return child;
                }
            }
            return null;
        }

        public boolean isEndOfWord() {
            return this.isEndOfWord;
        }
}
