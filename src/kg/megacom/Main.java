package kg.megacom;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("d:\\users\\asydykov\\Desktop\\java\\wiki.txt"));
            String k = "к";
            String text = new String(bytes, StandardCharsets.UTF_8);
            List<String> wikiText = Arrays.asList(text.split("\\PL+"));

            //  1) Вывести все слова, которые имеют не больше трех  символов и первая буква начинается на к;
            System.out.println(wikiText.stream()
                    .filter(s -> s.length() <= 3)
                    .filter(s -> s.startsWith("к"))
                    .collect(Collectors.toList()));

            //  2) Сгруппировать все слова в map<String,List<String>

            Map<String, List<String>> map = wikiText.stream().collect(Collectors.groupingBy(Function.identity()));
            System.out.println(map);




            //  3)Удалить из списка слов все слова, которые начинаются на р, поменять остальные на Uppercase

           wikiText.stream()
                    .filter(s -> !s.startsWith("р") && !s.startsWith("Р"))
                    .map(s -> s.toUpperCase())
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


            //  4)Отсортировать список слов в алфавитном порядке

            wikiText.stream()
                    .map(s -> s.toLowerCase())
                    .sorted().collect(Collectors.toList())
                    .forEach(System.out::println);


            //  5) Посчитать количество слов
            long count = wikiText.stream().count();
            System.out.println(count);

//            int count1 = 0;
//            for (String item : wikiText) {
//                count1++;
//            }
//            System.out.println(count1);


            //  6) Посчитать количество слов, имеющих более 5 символов
            long count1 = wikiText.stream()
                    .filter(s -> s.length()>5)
                    .count();
            System.out.println(count1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}


