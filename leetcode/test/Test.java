package test;

public class Test {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] > arr[i]) {
                System.out.println(arr[i]);
            }
        }

        char ch = 65;// 1 is the ASCII value of start of heading
        System.out.println(ch);
        int ans = 2;
        // char c = getChar(ans);
        // System.out.println(c);
        // String str = ch + "" + c;
        System.out.println(Math.ceil(1/26));
        // System.out.println(str);
        System.out.println(new Test().convertToTitle(701));
        String str = "abc";
        String[] arr1 = str.split("");
        int[] check = new int[26];
        for(char c : str.toCharArray()){
            check[c - 'a']++;
        }
        for (int i = 0; i < check.length; i++) {
            System.out.println(check[i]);
        }
        System.out.println(arr1.length);
        Set<String> set = new HashSet<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26; // Adjust for 0-based indexing
            char ch = getCharValue(remainder);
            str.insert(0, ch);
            columnNumber = (columnNumber - 1) / 26; // Adjust for 1-based indexing
        }
        return str.toString();
    }
    
    private char getCharValue(int i) {
        return (char)(i + 65); // 65 is the ASCII value of 'A'
    }
}
