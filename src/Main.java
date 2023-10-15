import phonebook.PhoneBook;
import phonebook.Records;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<String> checkList = new ArrayList<>();
        checkList.add("apple");
        checkList.add("pear");
        checkList.add("melon");
        checkList.add("grape");
        checkList.add("orange");
        checkList.add("apple");
        checkList.add("pear");
        checkList.add("pear");
        checkList.add("pear");
        checkList.add("apple");
        countOccurance(checkList,"pear");
//====================================================================

        List<Integer> toUniqList = new ArrayList<>();
        toUniqList.add(1);
        toUniqList.add(1);
        toUniqList.add(3);
        toUniqList.add(3);
        toUniqList.add(5);
        toUniqList.add(7);
        toUniqList.add(7);
        toUniqList.add(7);
        toUniqList.add(5);
        System.out.println(findUnique(toUniqList));
//====================================================================

        List<String> animals = new ArrayList<>();
        animals.add("bird");
        animals.add("bird");
        animals.add("fox");
        animals.add("cat");
        animals.add("fox");
        calcOccurance(animals);
//====================================================================

        List<someWord> cnt = findOccurance(animals);
        for (someWord wd1 : cnt) {
            System.out.println(wd1);
        }

//====== PhoneBook ===================================================
        PhoneBook pBook = new PhoneBook();
        pBook.add(new Records("Иванов", "+3809711111111"));
        pBook.add(new Records("Иванов", "+3809777777777"));
        pBook.add(new Records("Петров", "+3809777777777"));

        Records rec1 = pBook.find("Иванов");
        System.out.println(rec1);

        List<Records> rec2 = pBook.findAll("Иванов");
        System.out.println(rec2);
    }

    public static void countOccurance(List<String> myList, String param) {
        int cnt = 0;
        for (String s :
                myList) {
            if (s.equals(param)) {
                cnt = cnt + 1;
            }
        }
        System.out.println("Количество повторений параметра: " + cnt);
    }

    public static List<Integer> toList(Integer[] toArray) {
        List<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, toArray);
        return arrayList;
    }

    public static Set<Integer> findUnique(List<Integer> ListToUnique) {
        Set<Integer> uniq = new LinkedHashSet<>(ListToUnique);
        return uniq;
    }

    public static List<someWord> calcOccurance(List<String> listAnimal) {
        Map<String, Integer> result = new HashMap<>();
        for (String s : listAnimal) {
            int cnt = result.containsKey(s) ? result.get(s) + 1 : 1;
            result.put(s, cnt);
        }
        Map<String, Integer> map = result;
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
        return null;
    }

    public static class someWord {
        String wrd;
        int cnt;

        public someWord(String wrd, int cnt) {
            this.wrd = wrd;
            this.cnt = cnt;
        }

        public String getWrd() {
            return wrd;
        }

        public int getCnt() {
            return cnt;
        }

        public void setWrd(String wrd) {
            this.wrd = wrd;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "{name: \"" + wrd + "\"" +
                    ", occurrence: " + cnt + "}";
        }
    }

    public static List<someWord> findOccurance(List<String> listAnimal) {
        Map<String, Integer> result = new HashMap<>();
        for (String s : listAnimal) {
            int cnt = result.containsKey(s) ? result.get(s) + 1 : 1;
            result.put(s, cnt);
        }

        List<someWord> map = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : result.entrySet()) {
            map.add(new someWord(pair.getKey(), pair.getValue()));
        }
        return map;
    }

}