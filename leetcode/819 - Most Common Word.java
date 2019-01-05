// Idea: Pretty straight forward hashmap/set problem. The hardest part is 
//       using the correct regex to filter the punctuation from the paragraph.

// Run Time: O(n^2) b/c we have to iterate through all the words in the paragraph and
//           then we have to iterate through all the values in the map. Feel like this
//           could definetly be improved without having to iterate through the map values
//           to find the max.

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<String>(Arrays.asList(banned));
        
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s");
        
        for(String str : words){
            if(!set.contains(str)){
                if(map.containsKey(str)){
                    map.put(str, map.get(str) + 1);
                } else{
                    map.put(str, 1);
                }
            }
        }
        
        int largest = 0;
        String answer = "";
        for(String key : map.keySet()){
            if(map.get(key) > largest){
                answer = key;
                largest = map.get(key);
            }
        }
        
        return answer;
    }
}