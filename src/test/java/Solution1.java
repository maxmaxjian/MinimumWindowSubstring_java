import java.util.HashMap;
import java.util.Map;

public class Solution1 implements Solution {
    @Override
    public String minWindow(String s, String t) {
        Map<Character,Integer> toFind = new HashMap<>();
        Map<Character,Integer> found = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!toFind.containsKey(t.charAt(i))) {
                toFind.put(t.charAt(i), 1);
            } else {
                toFind.put(t.charAt(i), toFind.get(t.charAt(i))+1);
            }
        }

        int begin = 0, end = begin;
        String result;
        while (end < s.length() && !contains(found, toFind)) {
            char ch = s.charAt(end);
            if (toFind.containsKey(ch)) {
                if (!found.containsKey(ch)) {
                    found.put(ch, 1);
                } else {
                    found.put(ch, found.get(ch) + 1);
                }
            }
            end++;
        }

        if (contains(found, toFind)) {
            while (begin < end) {
                char ch = s.charAt(begin);
                if (!found.containsKey(ch)) {
                    begin++;
                } else {
                    if (found.get(ch) > toFind.get(ch)) {
                        found.put(ch, found.get(ch) - 1);
                        begin++;
                    } else {
                        break;
                    }
                }
            }

            result = s.substring(begin, end);

            found.put(s.charAt(begin), found.get(s.charAt(begin)) - 1);
            begin++;
        } else {
            return "";
        }

        while (begin < s.length()) {
            while (end < s.length() && !contains(found, toFind)) {
                char ch = s.charAt(end);
                if (toFind.containsKey(ch)) {
                    if (!found.containsKey(ch)) {
                        found.put(ch, 1);
                    } else {
                        found.put(ch, found.get(ch) + 1);
                    }
                }
                end++;
            }

            if (contains(found, toFind)) {
                while (begin < end) {
                    char ch = s.charAt(begin);
                    if (!found.containsKey(ch)) {
                        begin++;
                    } else {
                        if (found.get(ch) > toFind.get(ch)) {
                            found.put(ch, found.get(ch) - 1);
                            begin++;
                        } else {
                            break;
                        }
                    }
                }

                if (end - begin < result.length()) {
                    result = s.substring(begin, end);
                }

                found.put(s.charAt(begin), found.get(s.charAt(begin)) - 1);
                begin++;
            } else {
                break;
            }
        }

        return result;
    }

    private boolean contains(Map<Character,Integer> m1, Map<Character,Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        } else {
            for (char k2 : m2.keySet()) {
                if (m1.get(k2) < m2.get(k2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
