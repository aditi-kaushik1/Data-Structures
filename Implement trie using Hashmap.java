//Trie class

import java.util.HashMap;

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

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
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
}


//Main class

import java .util.*;
public class Main
{
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("can");
        System.out.println("Done");
        System.out.println(trie.containsWord("can");
    }
}
