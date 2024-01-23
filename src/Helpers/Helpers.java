package Helpers;

import Entities.Book;
import Entities.Library;

import java.util.Scanner;
import java.util.stream.Stream;


public class Helpers {
    private static Scanner scanner = new Scanner(System.in);
    public static Library library = new Library();



//    public static boolean checkString(String name) {
//        String str = name.trim();
//        if (!str.isEmpty() && str.length() >= 2 && str.length() <= 20) {
//            if (!str.matches(".*\\d.*") && !str.matches(".*[\\p{Punct}].*")) {
//                return false;
//            }
//            else {
//                System.out.println("You cannot use punctuations,numbers and length must be 2-20");
//            }
//        }
//        else {
//            System.out.println("You cannot use punctuations,numbers and length must be 2-20");
//        }
//        return true;
//
//    }

    public static boolean checkString(String name) {
        boolean a= Stream.of(name.trim()).filter(str->!str.isEmpty() && str.length() >= 2 && str.length() <= 20
                && !str.matches(".*\\d.*") && !str.matches(".*[\\p{Punct}].*")).findFirst().isEmpty();
        if(a){
            System.out.println("You cannot use punctuations,numbers and length must be 2-20");
        }
        return a;
    }



//    public static boolean checkCount(String count) {
//        int a;
//        String word = count.trim();
//        if (!word.isEmpty()) {
//            a = tryParseInt(word);
//            if (a > 0 && a < 50) {
//                System.out.println("Successful");
//                return false;
//            }
//        }
//        System.out.println("Incorrect count");
//        return true;
//    }

    public static boolean checkCount(String count) {
        String word = count.trim();
        boolean b=Stream.of(word).mapToInt(Integer::parseInt).filter(a->a>0 && a<50).findFirst().isEmpty();
        if(b){
            System.out.println("Incorrect count");
        }
        return b;
    }

//    public static boolean checkPrice(String price) {
//        int a;
//        String word = price.trim();
//        if (!word.isEmpty()) {
//            a = tryParseInt(word);
//            if (a > 0 && a < 500) {
//                System.out.println("Successful");
//                return false;
//            }
//        }
//        System.out.println("Incorrect count");
//        return true;
//    }

    public static boolean checkPrice(String price) {
        String word = price.trim();
        boolean b=Stream.of(word).mapToInt(Integer::parseInt).filter(a->a>0 && a<500).findFirst().isEmpty();
        if(b){
            System.out.println("Incorrect price");
        }
        return b;
    }


    public static int tryParseInt(String choise) {
        int input = 0;
        try {
            input = Integer.parseInt(choise);
        } catch (Exception e) {
            System.out.println("Incorrect number");
        }
        return input;
    }

    public static Library createBook(int number) {

        Boolean a = true;
        String name = null;
        String author = null;
        String language = null;
        String price = null;
        String count = null;
        for (int i = 1; i <= number; i++) {
            while (a) {
                System.out.println("Please, enter book name length between 5-20");
                name = scanner.nextLine();
                a = Helpers.checkString(name);
            }
            a=true;
            while (a) {
                System.out.println("Please, enter book author length between 5-20");
                author = scanner.nextLine();
                a = Helpers.checkString(author);
            }
            a=true;
            while (a) {
                System.out.println("Please, enter book language length between 5-20");
                language = scanner.nextLine();
                a = Helpers.checkString(language);
            }
            a=true;
            while (a) {
                System.out.println("Please, enter book count");
                count = scanner.nextLine();
                a = Helpers.checkCount(count);
            }
            a=true;
            while (a) {
                System.out.println("Please, enter book price");
                price = scanner.nextLine();
                a = Helpers.checkPrice(price);
            }
            Book book = new Book(name, author, language, count, price);
            library.addBook(book);
            System.out.println("You successfully created book");
            a=true;

        }
        return library;
    }





}
