class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : banned){
            bannedWords.add(str);
        }
        
        String[] words = paragraph.toLowerCase().replaceAll(", .", "|").split("|");
        
        for(String word : words){
            if(bannedWords.contains(word)){
                if(map.containsKey(word)){
                    map.put(word, map.get(word) + 1);
                } else{
                    map.put(word, 1);
                }
            }
        }
        
        int largest = 0;
        String answer = "";
        
        for(String key : map.keySet()){
            if(map.get(key) > largest){
                largest = map.get(key);
                answer = key;
            }
        }
        
        return answer;
    }
}