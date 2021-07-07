static void insert(TrieNode root, String key) 
{
    TrieNode current = root;
    for(char c : key.toCharArray()) {
        if(current.children[c - 'a'] == null)
            current.children[c - 'a'] = new TrieNode();
        current = current.children[c - 'a'];
    }
    current.isEndOfWord = true;
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    TrieNode current = root;
    for(char c : key.toCharArray()) {
        if(current.children[c - 'a'] == null)
            return false;
        current = current.children[c - 'a'];
    }
    return current.isEndOfWord;
}
