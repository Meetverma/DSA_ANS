
class Solution {
    class Node{
        Node [] ch = new Node[26];
        int cnt;
        Node(){
            this.cnt = 0;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Node rootNode = new Node();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            Node node = rootNode ;
            
            for(char c: word.toCharArray()){
                if(node.ch[c-'a'] == null ){
                    node.ch[c-'a'] = new Node();
                }
                node = node.ch[c-'a'];
                node.cnt++;
            }
        }
        int ans[] = new int[words.length];

        for(int i=0;i<words.length;i++){
            Node node = rootNode;
            int temp = 0;
            for(char c: words[i].toCharArray()){
                node = node.ch[c-'a'];
                temp+=node.cnt;
            }
            ans[i]=temp;
        }
    return ans;
    }
}
