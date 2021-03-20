public class Validation {

    public static boolean isCorrect(String s) {
        if (!checkSymbols(s)) {
            System.out.println("Incorrect symbols");
            return false;
        }

        if (!checkNumberOfBrackets(s)) {
            System.out.println("Incorrect number of brackets");
            return false;
        }

        return true;
    }

    // Проверяем на число скобок
    public static boolean checkNumberOfBrackets(String s) {
        int tmp = 0;

        for (char c : s.toCharArray()) {
            if (c == '[')
                tmp++;
            else if (c == ']')
                tmp--;
            if (tmp < 0) {
                return false;
            }
        }

        return tmp == 0;
    }
    // Проверяем на допустимые символы
    public static boolean checkSymbols(String s) {
        return s.matches("[a-zA-Z\\[\\]\\d]+");
    }
}