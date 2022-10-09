import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

/*
Задача 1 Сгенерируйте массив целых чисел, используя класс Random(). Используя методы
классов-коллекций:
Е) найдите указанное число в массиве  (вариант 8)

Задача 3 Напишите функцию проверки вхождения списка L1 в список L2
(вариант 12).

Файлы:
ВАРИАНТ 6.
1)	Заполнить файл f целыми числами, полученными с помощью генератора случайных чисел. Получить в файле g все компоненты файла f, которые делятся на т и не делятся на п.
2)	Дан файл, содержащий текст на русском языке. Определить, сколько раз встречается в нем самое длинное слово.
3)	Дан файл в json формате, содержащий сведения о спринтерах (ФИО спортсмена, страна, длина дистанции в метрах, результат в часах, минутах и секундах).
Определите, улучшен ли мировой рекорд по данной дистанции и на сколько секунд.

 */


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {
        while (true) {
            System.out.println("\n1: Работа с коллекциями №1;"
                    + "\n2: Работа с коллекциями №2;"
                    + "\n3: Работа с файлами №1;"
                    + "\n4: Работа с файлами №2;"
                    + "\n5: Работа с файлами №3;"
                    + "\nВведите номер задачи: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    CollectionFirst();
                    break;
                }
                case "2": {
                    CollectionSecond();
                    break;
                }
                case "3": {
                    FileFirst();
                    break;
                }
                case "4": {
                    FileSecond();
                    break;
                }
                case "5": {
                    FileThird();
                    break;
                }

                case "6": {
                    return;
                }
            }
        }
    }

    public static void CollectionFirst() {
        //создайте массив, содержащий все положительные числа первого массива  (вариант 6)

        Vector<Integer> list = new Vector<>();
        Vector<Integer> newList = new Vector<>();
        System.out.println("Введите искомое число");
        int n = scanner.nextInt();
        for (int i = 0; i < 50; i++) {
            list.add(new Random().nextInt() % 50);
            System.out.print(list.get(i) + " ");
        }
    boolean isfound=false;
        for (int i = 0; i < 50; i++) {
          if (list.get(i)==n){
              System.out.println("Число найдено на "+ i + " позиции");
              isfound=true;
              break;
          }
        }
        if(!isfound)
            System.out.println("Число не найдено");
    }



    public static void CollectionSecond() {
        /*
        Задача 5.  Опишите очередь и заполните ее вещественными числами.
        Выполните циклический сдвиг элементов в очереди так, чтобы в ее начале был расположен наибольший элемент  (вариант 14).
         */
            ArrayList<Integer> L1 = new ArrayList<>();
            ArrayList<Integer> L2 = new ArrayList<>();


        System.out.println("Введите количество элементов 1 списка");
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            L1.add(scanner.nextInt());
        }
        System.out.println("Введите количество элементов 2 списка");
        n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
                L2.add(new Random().nextInt() % 5);
            }
        for (int i = 0; i < 10; i++) {
            System.out.print(L2.get(i) + " ");
        }
            int counter = 0;
            for (int a : L1) {
                for (int l : L2) {
                    if (a == l) {
                        counter++;
                        break;
                    }
                }
            }
            if (counter == L1.size()) {
                System.out.println("Список L1 входит в список L2");
            } else {
                System.out.println("Список L1 не входит в L2");
            }
        }
    public static void FileFirst() throws IOException {
        /*
        1)	Заполнить файл f целыми числами, полученными с помощью генератора случайных чисел.
        Получить в файле g все компоненты файла f, которые делятся на т и не делятся на п.
        */
        System.out.println("Введите название файла: ");
        String f = scanner.nextLine();
        System.out.println("Введите название второго файла: ");
        String g = scanner.nextLine();
        System.out.println("Введите число на которое должны делиться элементы массива: ");
        Integer t = scanner.nextInt();
        System.out.println("Введите число на которое НЕ должны делиться элементы массива: ");
        Integer n = scanner.nextInt();

        FileWriter writer = new FileWriter(f + ".txt");
        for (int i = 0; i < 30; i++) {
            writer.append(new Random().nextInt() % 50 + 50 + ",");
        }
        writer.flush();
        writer = new FileWriter(g + ".txt");
        FileReader reader = new FileReader(f + ".txt");
        int c;
        StringBuilder stringBuilder = new StringBuilder();
        while ((c = reader.read()) != -1) {
            stringBuilder.append((char) c);
        }
        int temp = 0;
        for (int i = 0; i < stringBuilder.toString().split(",").length; i++) {
            temp = Integer.parseInt(stringBuilder.toString().split(",")[i]);
            if (temp % t == 0 && temp % n != 0) writer.append(temp + ",");
        }
        writer.flush();
        System.out.println("Done.");
    }

    public static void FileSecond() throws IOException {
        // 2)	Дан файл, содержащий текст на русском языке. Определить, сколько раз встречается в нем самое длинное слово.
        FileReader reader = new FileReader("3.txt");
        StringBuilder stringBuilder = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            stringBuilder.append((char) c);
        }
        String maxLengthWord = "";
        int maxLength = 0;
        int temp;
        String[] line = stringBuilder.toString().split(" ");
        for (int i = 0; i < line.length; i++) {
            temp = length(line[i]);
            if (temp > maxLength) {
                maxLength = temp;
                maxLengthWord = line[i];
            }
        }
        int count = 0;
        for (String word : line) {
            if (word.equals(maxLengthWord)) count++;
        }
        System.out.println("Содержание слова " + maxLengthWord + " в тексте: " + count);
    }

    public static int length(String line) {
        StringBuilder sb = new StringBuilder();
        char temp = ' ';
        for (int i = 0; i < line.toCharArray().length; i++) {
            temp = line.toCharArray()[i];
            if (temp != '!' && temp != ';' && temp != '.' && temp != ',' && temp != '?' && temp != '(' && temp != ')' && temp != ':') {
                sb.append(temp);
            }
        }
        return sb.length();
    }

    public static void FileThird() throws IOException, ParseException {
        /*3)
                Определите, улучшен ли мировой рекорд по данной дистанции и на сколько секунд.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите рекорд - (hh:mm:ss):");
        String line = scanner.nextLine();
        int[] recordTime = new int[]{Integer.parseInt(line.split(":")[0]), Integer.parseInt(line.split(":")[1]), Integer.parseInt(line.split(":")[2])};
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        JSONArray athletesJSON = (JSONArray) parser.parse(new FileReader("athletes.json"));
        ArrayList<Athlete> athletesArray = new ArrayList<>(athletesJSON.size());
        for (Object o : athletesJSON) {
            JSONObject athlete = (JSONObject) o;
            athletesArray.add(new Athlete((String) athlete.get("fio"), (String) athlete.get("country"), (String) athlete.get("distance"), (String) athlete.get("result")));
        }
        int[] tempTime = new int[]{0};
        boolean wasBeaten = false;
        for (Athlete c : athletesArray) {
            tempTime = new int[]{Integer.parseInt(c.getResult().split(":")[0]),
                    Integer.parseInt(c.getResult().split(":")[1]),
                    Integer.parseInt(c.getResult().split(":")[2])};
            if (tempTime[0] < recordTime[0] ||
                    tempTime[0] == recordTime[0] && tempTime[1] < recordTime[1] ||
                    tempTime[0] == recordTime[0] && tempTime[1] == recordTime[1] && tempTime[2] < recordTime[2]) {
                recordBeaten(c, new int[]{recordTime[0] - tempTime[0], recordTime[1] - tempTime[1], recordTime[2] - tempTime[2]});
            }
        }
    }

    public static void recordBeaten(Athlete c, int[] diff) {
        System.out.print("Атлет " + c.getFIO() + " побил рекорд поставленным временем: " + c.getResult() +
                "\nРезультат был улучшен на ");
        if (diff[0] != 0) System.out.print(diff[0] + " час(а/ов) ");
        if (diff[1] != 0) System.out.print(diff[1] + " минут(у/ы) ");
        if (diff[2] != 0) System.out.print(diff[2] + " секунд(у/ы) ");
        System.out.println();
    }



}