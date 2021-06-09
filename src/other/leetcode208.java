package other;
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
//        示例:
//
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true
import java.util.*;
public class leetcode208 {
    /** Initialize your data structure here. */
    Treenode root = new Treenode();
    class Treenode{
        Treenode[] links;
        boolean isEnd = false;
        final int R = 26;
        public Treenode(){
            links = new Treenode[R];
        }
        public void putnode(char ch){
            links[ch-'a'] = new Treenode();
        }
        public boolean contain(char ch){
            return links[ch-'a']!=null;
        }
        public void setEnd(){
            isEnd = true;
        }
        public boolean isend(){
            return isEnd;
        }
    }
    public leetcode208() {
        Treenode root = new Treenode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Treenode node = root;
        for(int i=0;i<word.length();i++){
            char now = word.charAt(i);
            if(!node.contain(now)){
                node.putnode(now);
            }
            node = node.links[now-'a'];
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Treenode node = root;
        for(int i=0;i<word.length();i++){
            char now = word.charAt(i);
            if(!node.contain(now)){
                return false;
            }
            node = node.links[now-'a'];
        }
        return node.isend();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Treenode node = root;
        for(int i=0;i<prefix.length();i++){
            char now = prefix.charAt(i);
            if(!node.contain(now)){
                return false;
            }
            node = node.links[now-'a'];
        }
        return true;
    }

    //public static void main(String[] args) {
//        String Str = new String("www.runoob.com");
//
//        System.out.print("返回值 :" );
//        System.out.println(Str.startsWith("www.runoob.com") );
}
