import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*  Задание 1
Пользователь с клавиатуры вводит путь к файлу.
После чего содержимое файла отображается на экране.
  Задание 2
К первому заданию добавить поэкранный вывод, если содержимое файла не помещается на экране.
   Задание 3
  Пользователь с клавиатуры вводит путь к файлу и слово для поиска.
  После работы программы на экран отображается количество раз сколько слово встречается в файле.*/

        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = in.nextLine();
        File file = new File(path);
        System.out.println("Введите слово для поиска");
        String str = in.nextLine();
        in.close();

        if (file.exists()) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(path));) {
                String line = null;
                int num = 0;
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                    String[] text = line.split(" ");
                    for (String t : text)
                        if (t.equals(str)) num++;
                }
                System.out.println("-------------------------");
                System.out.println("введенное слово встречается в тексте " + num + " раз");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("file doesn't exist");
        }





    }
}

/*

Задание 4
Пользователь с клавиатуры вводит путь к файлу.
После работы программы на экран отображается количество букв, чисел и знаков препинания в файле.

Задание 5
Пользователь с клавиатуры вводит путь к файлу, слово для поиска и слово для замены.
Программа ищет искомое слово и производит замену на второе слово.
После работы программы на экран отображается отчет с информацией о количестве замен

Задание 6
Пользователь с клавиатуры вводит пути к четырем файлам.
Программа должна содержимое трёх файлов записать в четвертый файл.
После работы программы на экран отображается отчет с информацией о количестве перенесенных байт.

Задание 7
Пользователь с клавиатуры вводит путь к файлу и список запрещенных слов.
Программа должна вырезать запрещенные слова из файла.
После работы программы на экран отображается отчет с информацией о количестве вырезанных слов
с детализацией по каждому слову
 */