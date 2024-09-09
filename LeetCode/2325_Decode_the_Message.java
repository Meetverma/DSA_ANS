// Time Complexity: O(Max(key.length(),message.length()))
// Space Complexity: O(Max(key.length(),message.length()))

class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();

        Character arr[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v', 'w', 'x', 'y', 'z' };

    int y = 0;

        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i) !=' '){
                if (!map.containsKey(key.charAt(i))) {
                    map.put(key.charAt(i), arr[y++]);
                }
            }
        }
        StringBuilder x = new StringBuilder(" ".repeat(message.length()));

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                x.setCharAt(i,map.get(message.charAt(i)));
            }
        }
        return new String(x);

    }
}2325. Decode the Message
