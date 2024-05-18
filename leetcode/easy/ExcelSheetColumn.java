public class ExcelSheetColumn {

    public String convertToTitle(int columnNumber) {
        String str = "";
        while (columnNumber > 0) {
            char ch = getCharValue((columnNumber - 1) % 26);
            str = ch + "" + str;
            columnNumber = (columnNumber - 1) / 26; // subtracting 1 because we are starting from 1
            //Ex. 26 -> Z if we dont subtract 1 then it will be AA because of 26 % 26 = 0
            // 26 - 1 = 25 % 26 = 25 -> Z there will extra iteration if we dont subtract 1
        }

        return str;

    }

    private char getCharValue(int i) {
        return (char) (i + 65);
    }
}
