//Trie class -

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node (char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
    public Node root = new Node(' ');

    public void insert(String word)  {
        Node current = root;
        for(var ch : word.toCharArray()) {
            if(current.children[ch - 'a'] == null)
                current.children[ch - 'a'] = new Node(ch);
            current = current.children[ch - 'a'];
        }
        current.isEndOfWord = true;
    }
}

//Main class - 

import java .util.*;
public class Main
{
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("can");
        System.out.println("Done");
    }
}
