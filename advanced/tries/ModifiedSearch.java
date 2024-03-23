package tries;
import java.util.ArrayList;

public class ModifiedSearch {
    
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        StringBuilder result = new StringBuilder();
        for (String b : B) {
            boolean found = false;
            for (int i = 0; i < b.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == b.charAt(i))
                        continue;
                    String modified = b.substring(0, i) + c + b.substring(i + 1);
                    if (A.contains(modified)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }
            result.append(found ? '1' : '0');
        }
        return result.toString();
    }
}
