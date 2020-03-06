import java.util.*;

public class findDuplicateFile {
    public static List<List<String>> mySolution(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String path: paths) {
            String[] split = path.split(" ");
            String head = split[0]; // the path head

            // for every file, extract their content as map key, and combine its path as map value
            for (int i = 1; i < split.length; i++) {
                String[] s = split[i].split("\\(");
                String fileName = s[0];
                String fileContent = s[1].substring(0,s[1].length() - 1);

                if (map.containsKey(fileContent)) {
                    map.get(fileContent).add(head + "/" + fileName);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(head + "/" + fileName);
                    map.put(fileContent, tmp);
                }
            }
        }

        for (List list: map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(mySolution(input));
    }
}
