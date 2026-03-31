class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode finalNode = loopTrie(word);
        return finalNode != null ? finalNode.endOfWord : false;
    }

    public boolean startsWith(String prefix) {
        TrieNode finalNode = loopTrie(prefix);
        return finalNode != null ? true : false;
    }

    private TrieNode loopTrie(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return null;
            }
            curr = curr.children.get(c);
        }
        return curr;
    }
}
