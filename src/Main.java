import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

// Вводим строку
        System.out.print("Input string: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s =reader.readLine();
// Проверяем входную строку на валидность
        if (Validation.isCorrect(s)) {
            StringBuilder sb = new StringBuilder(s);

// Пока строка содержит "["
            while (sb.toString().contains("[")) {
                String substr = "";

// Получаем индекс последней "["
                int startBracket = sb.lastIndexOf("[");

// Получаем индекс "]" от последней "["
                int endBracket = sb.indexOf("]", startBracket);

// Получение индекса цифры до "["
                int digit = startBracket - 1;
//Получаем сколькизначное число перед "["
                int sum = 0;
                for (int i = 0; (digit - i) >= 0; i++) {
                    if (Character.isDigit(sb.charAt(digit - i))) {
                        sum++;
                    } else break;
                }
//Получаем число перед "["
                String k = "";
                for (int i = 0; i < sum; i++) {
                    String z = Character.toString(sb.charAt(digit - i));
                    k = z+k;
                }
               int count = Integer.parseInt(k);

//Получаем строку, содержащую необходимое количество повторов и заменяем ею число и скобки
                for (int i = 0; i < count; i++) {
                    substr += sb.substring(startBracket + 1, endBracket);
                }
                sb.replace(digit-sum+1, endBracket + 1, substr);
            }
            System.out.println("Output string: " + sb.toString());
        }


    }
}
