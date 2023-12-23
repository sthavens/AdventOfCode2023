import java.util.Optional;

public class Trie {
    private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(String word, String replacementCharacter) {
            Node current = root;

            for(int i = 0; i < word.length(); i++) {
                if(!current.contains(word.charAt(i))) {
                    if (i == word.length() - 1) {
                        current.children.add(new Node(word.charAt(i), replacementCharacter));
                    }
                    else {
                        current.children.add(new Node(word.charAt(i)));
                    }
                }
                current = current.get(word.charAt(i));
            }
        }

        public Optional<String> search(String text) {
            Node current = root;

            for (char i : text.toCharArray()) {
                if (current.contains(i)) {
                    current = current.get(i);
                    if (current.isEndOfWord()) {
                        return Optional.of(current.returnChar);
                    }
                }
                else {
                    return Optional.empty();
                }
            }
            
            return Optional.empty();
        }
}
