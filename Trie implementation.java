//Trie class

import java.util.*;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node (char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }
    public Node root = new Node(' ');

    public void insert(String word)  {
        Node current = root;
        for(var ch : word.toCharArray()) {
            if(!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean containsWord(String word) {
        if(word == null)
            return false;

        Node current = root;
        for(char ch : word.toCharArray()) {
            if(current.getChild(ch) == null)
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public boolean contains(String word) {
        if(word == null || word.length() == 0)
            return false;
        return contains(root, word, 0);
    }

    private boolean contains(Node root, String word, int index) {
        var ch = word.charAt(index);
        if(root.children.get(ch) == null)
            return false;
        if(index == word.length() - 1) {
            return root.children.get(ch).isEndOfWord;
        }

        return contains(root.children.get(ch), word, index + 1);
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        System.out.println(root.value);

        for(var child : root.getChildren())
            traverse(child);
    }

    public void remove(String word) {
        if(word == null || !containsWord(word))
            return;
        remove(root, word, 0);
    }
    public void remove(Node root, String word, int index) {
        //1st term is root, not any character frm the word
        if(index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);

        //when word not present
        if(child == null)
            return;
        remove(child, word, index + 1);

        if(!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public int numberOfWords() {
        return findWords("").size();
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> list) {
        if(root == null)
            return;
        if(root.isEndOfWord)
            list.add(prefix);
        for(var child : root.getChildren())
            findWords(child, prefix + child.value, list);
    }

    private Node findLastNodeOf(String prefix) {
        if(prefix == null)
            return null;
        Node current = root;
        for(var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if(child == null)
                return null;
            current = child;
        }
        return current;
    }
}

//Main class

import java .util.*;
public class Main
{
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("can");
        trie.insert("canada");
        trie.insert("car");
        trie.insert("carpool");
        //System.out.println(trie.containsWord(null));
        //trie.traverse();
        //trie.remove("canada");
        //trie.traverse();
        //System.out.println(trie.containsWord("car"));
        //System.out.println(trie.containsWord("care"));
        System.out.println(trie.contains(""));
        //System.out.println(trie.findWords(""));
        //System.out.println(trie.numberOfWords());
    }
}
