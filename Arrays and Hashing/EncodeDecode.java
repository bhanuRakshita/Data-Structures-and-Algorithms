import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static String encode(List<String> strs) {
        StringBuilder codedString = new StringBuilder();
        for (String s : strs) {
            codedString.append(s.length()).append('#').append(s);
        }
        return codedString.toString();
    }
    
    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            // Find the '#' that separates length from string
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++; // move past '#'
            String newStr = str.substring(j, j + length);
            res.add(newStr);
            i = j + length;
        }
        return res;
    }

    public static void main(String[] args){
        List<String> strs = new ArrayList<>(List.of("s1", "s2", "s3"));
        String res = encode(strs);
        System.out.println(res);
        System.out.println("=============");
        List<String> res2 = decode(res);

        int i = 0;
        while (i<res2.size() && res2.get(i)!=null) {
            System.out.println(res2.get(i));
            i++;
        }
    }
}
