package easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i -= 1;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j -= 1;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String a = "11", b = "1";
        System.out.println(ab.addBinary(a, b));
        int abc = '1' - '0'; // converting char to int
        System.out.println(abc);
    }
}
