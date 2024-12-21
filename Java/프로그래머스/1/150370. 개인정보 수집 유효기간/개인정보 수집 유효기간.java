import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<Integer>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now = LocalDate.parse(today, formatter);
        Map<String, Integer> termMap = new HashMap<String, Integer>();
        for(String term: terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String privacie = privacies[i];
            String[] p = privacie.split(" ");
            
            LocalDate date = LocalDate.parse(p[0], formatter);
            Integer term = termMap.get(p[1]);
            date = date.plusMonths(term);
            if(date.compareTo(now) <= 0) {
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}