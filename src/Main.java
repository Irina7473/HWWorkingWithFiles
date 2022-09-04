import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        /*  Задание 1
Пользователь с клавиатуры вводит путь к файлу.
После чего содержимое файла отображается на экране.
   Задание 3
  Пользователь с клавиатуры вводит путь к файлу и слово для поиска.
  После работы программы на экран отображается количество раз сколько слово встречается в файле.
  Задание 4
Пользователь с клавиатуры вводит путь к файлу.
После работы программы на экран отображается количество букв, чисел и знаков препинания в файле.

Задание 5
Пользователь с клавиатуры вводит путь к файлу, слово для поиска и слово для замены.
Программа ищет искомое слово и производит замену на второе слово.
После работы программы на экран отображается отчет с информацией о количестве замен

  */

        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = in.nextLine();
        File file = new File(path);
        System.out.println("Введите слово для поиска");
        String str1 = in.nextLine();
        System.out.println("Введите слово для замены");
        String str2 = in.nextLine();
        in.close();

        String line = null, change="";;
        int words = 0, symbols=0, letters = 0, numbers = 0, marks = 0;
        Matcher m;
        Pattern punct = Pattern.compile("\\p{Punct}");
        Pattern numb = Pattern.compile("[0-9]");
        Pattern word = Pattern.compile(str1 + "(\\w*)");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(path));) {
                while ((line = br.readLine()) != null) {
                    String[] text = line.split("\n");
                    for (String t : text) {
                        symbols += t.length();
                        m = punct.matcher(t);
                        while (m.find()) marks++;
                        m = numb.matcher(t);
                        while (m.find()) numbers++;
                        m = word.matcher(t);
                        while (m.find()) {
                            words++;
                            //t = str2;
                            System.out.println(m.group());
                        }

                        t =t.replaceAll(str1 + "(\\w*)", str2);
                        change += (t + "\n ");
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println(change);
            System.out.println("введенное слово встречается в тексте " + words + " раз");
            letters = symbols - numbers - marks;
            System.out.println("В тексте " + letters + " букв, " + numbers + " цифр " + marks + " знаков препинания");
            System.out.println("-------------------------");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                bw.write(change);
                bw.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else{
            System.out.println("file doesn't exist");
        }

    }
}

/*
Задание 2
К первому заданию добавить поэкранный вывод, если содержимое файла не помещается на экране.

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