package Entities;
import Helpers.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import static Helpers.Helpers.*;

public class Library {
    public static ArrayList<Book> books;
    private static Scanner scanner=new Scanner(System.in);

    public Library(){
        books=new ArrayList<>();
    }

//    public void addBook(Book book){
//        Boolean bool=false;
//        for(Book Existbook:books){
//            if(book.name==Existbook.name && book.author== Existbook.author && book.language==Existbook.language){
//
//                bool=true;
//                break;
//            }
//        }
//        if(!bool){
//            books.add(book);
//        }
//    }

    public void addBook(Book book){
        boolean existBook=books.stream().filter(existsBook->existsBook.name.equals(book.name) &&
                existsBook.author.equals(book.author) && existsBook.language.equals(book.language)).
                peek(existsBook->existsBook.count+="+"+book.count).findFirst().isEmpty();
        if(existBook){
            books.add(book);
        }
    }

//    public void ShowBooks(){
//        for (Book item: books){
//            item.fullInfo();
//        }
//
//    }

    public void ShowBooks(){
        books.forEach(Book::fullInfo);

    }

//    public void deleteBook(int id){
//        Boolean bool=false;
//        for (Book book: books){
//            if (book.getId()==id){
//                books.remove(book);
//                bool=true;
//                System.out.println("Successful");
//                break;
//            }
//        }
//        if(!bool){
//            System.out.println("invalid id");
//        }
//    }

    public void deleteBook(int id){
        boolean bool=books.removeIf(book -> book.getId()==id);
        if(!bool){
            System.out.println("invalid id");
        }
    }


//    public void deleteAllBook(){
//        ArrayList<Book> removeBook=new ArrayList<>();
//        for (Book book: books){
//            removeBook.add(book);
//        }
//        books.removeAll(removeBook);
//        System.out.println("Successful");
//
//    }

    public void deleteAllBook(){
        ArrayList<Book> removeBook=new ArrayList<>(books);
        books.removeIf(book -> true);


    }



//    public void findBook(String word){
//        ArrayList<Book> samebooks = new ArrayList<>();
//        String lowerCaseWord = word.toLowerCase().trim();
//        for (Book book : books) {
//                if (book.author.toLowerCase().equals(lowerCaseWord)
//                        || book.language.toLowerCase().equals(lowerCaseWord)
//                        || book.name.toLowerCase().equals(lowerCaseWord)) {
//                    samebooks.add(book);
//            }
//        }
//        if (!samebooks.isEmpty()) {
//            System.out.println("Books:");
//            for (Book Books : samebooks) {
//                Books.fullInfo();
//            }
//        } else {
//            System.out.println("No matching books found.");
//        }
//    }


    public void findBook(String word){
        String lowerCaseWord = word.toLowerCase().trim();
        List<Book> samebooks=books.stream().filter(book->book.author.toLowerCase().equals(lowerCaseWord)
                        || book.language.toLowerCase().equals(lowerCaseWord)
                       || book.name.toLowerCase().equals(lowerCaseWord)).toList();
        if (!samebooks.isEmpty()) {
            System.out.println("Books:");
            samebooks.forEach(Book::fullInfo);
        } else {
            System.out.println("No matching books found.");
        }
    }



//        public void updateBook(String word, String i,int id) {
//            String author = "author";
//            String lang = "language";
//            String name = "name";
//            String count = "count";
//            String price = "price";
//            for (Book book : books) {
//                if(book.getId()==id){
//                    if (!checkString(word)) {
//                        if (author.equals(i)) {
//                            book.author = word;
//                            System.out.println("Successful");
//                        } else if (name.equals(i)) {
//                            book.name = word;
//                            System.out.println("Successful");
//                        } else if (lang.equals(i)) {
//                            book.language = word;
//                            System.out.println("Successful");
//                        }
//                    } else if (tryParseInt(word)>0) {
//                        if(count.equals(i) && !checkCount(word)){
//                            book.count = word;
//                            System.out.println("Successful");
//                        } else if (price.equals(i) && !checkPrice(word)) {
//                            book.price = word;
//                            System.out.println("Successful");
//                        }
//
//                    }
//
//                }
//            }
//        }

    public void updateBook(String word, String i,int id) {
        String author = "author";
        String lang = "language";
        String name = "name";
        String count = "count";
        String price = "price";
        books.stream().filter(book->book.getId()==id).findFirst().
                ifPresent(book -> {
                    if(!checkString(word)){
                        switch (i){
                            case "author":
                                book.author="author";
                                break;
                            case "name":
                                book.name="name";
                                break;
                            case "language":
                                book.name="language";
                                break;
                        }
                    } else if (tryParseInt(word)>0) {
                        if(count.equals(i) && !checkCount(word)){
                            book.count = word;
                            System.out.println("Successful");
                        } else if (price.equals(i) && !checkPrice(word)) {
                            book.price = word;
                            System.out.println("Successful");
                        }
                    }
                });
    }



    public void increaseNum(int id,String str){
        String p="price";
        String c="count";
        for(Book book:books){
            if(book.getId()==id){

                int a=Integer.valueOf(book.price);
                if(str==p){
                    System.out.println("Enter book price you want to increase");
                    int inprice=tryParseInt(scanner.nextLine());
                    if(inprice>0){
                        int z=a+inprice;
                        if (z<500){
                            book.price=String.valueOf(z);
                        }
                        else {
                            System.out.println("Price exceeds");
                        }
                    }
                }
                int b=Integer.valueOf(book.count);
                if(str==c){
                    System.out.println("Enter book count you want to increase");
                    int incount=tryParseInt(scanner.nextLine());
                    if(incount>0){
                        int z=b+incount;
                        if (z<50){
                            book.count=String.valueOf(z);
                        }
                        else {
                            System.out.println("Stock exceeds");
                        }
                    }
                }
            }

        }

    }

    public void decreaseNum(int id,String str){
        String p="price";
        String c="count";
        for(Book book:books){
            if(book.getId()==id){

                int a=Integer.valueOf(book.price);
                if(str==p ){
                    System.out.println("Enter book price you want to decrease");
                    int deprice=tryParseInt(scanner.nextLine());
                    if(deprice<=a && deprice>0){
                        a-=deprice;
                        book.price=String.valueOf(a);
                    }
                    else {
                        System.out.println("Incorrect price");
                    }
                }
                int b=Integer.valueOf(book.count);
                if(str==c ){
                    System.out.println("Enter book number of count you want to decrease");
                    int decount=tryParseInt(scanner.nextLine());
                    if(decount<=b && decount>0){
                        b-=decount;
                        book.count=String.valueOf(b);
                    }
                    else {
                        System.out.println("Incorrect count");
                    }
                }
            }
            else {
                System.out.println("incorrect id");
            }

        }






    }
}
