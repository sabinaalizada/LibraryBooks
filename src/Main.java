
import Helpers.Helpers;

import java.util.Scanner;

import static Helpers.Helpers.library;
import static Helpers.Helpers.tryParseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean a =true;


            while (a){
                Scanner scanner=new Scanner(System.in);
                String libraryname = null;
                while (a){
                    System.out.println("Please, enter library name length between 3-20");
                    Scanner scan=new Scanner(System.in);
                    libraryname= scan.nextLine();
                    a=Helpers.checkString(libraryname);
                }

                System.out.println("---------------------------------------------------------");
                System.out.println( "Welcome to " + libraryname + " library");
                System.out.println("---------------------------------------------------------");
                a=true;

                while (a){
                    boolean returnToManu=false;
                    System.out.println("What do you want to do?");
                    System.out.println("------------------------------------------------------");
                    System.out.println("1.Add book 2.Remove Book 3.Increase Count  4.Decrease Count 5.Increase Price 6.Decrease Price 7.Search Book 8.Show all books 9.Update Book 10.Delete all books 11.Quit");
                    String choise=scanner.nextLine();
                    int result= tryParseInt(choise);
                    switch (result){
                        case 1:
                            System.out.println("How many books or book you want to add");
                            int numBooks=tryParseInt(scanner.nextLine());
                            Helpers.library=  Helpers.createBook(numBooks);
                            break;
                        case 2:
                            if(!library.books.isEmpty()){
                                System.out.println("Enter book id");
                                int id=tryParseInt(scanner.nextLine());
                                Helpers.library.deleteBook(id);
                                System.out.println("Successful");
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }
                            break;
                        case 3:
                            if(!library.books.isEmpty()){
                                System.out.println("Enter book id");
                                int countid=tryParseInt(scanner.nextLine());
                                Helpers.library.increaseNum(countid,"count");
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }

                            break;
                        case 4:
                            if(!library.books.isEmpty()){
                                System.out.println("Enter Book Id");
                                int idcount=tryParseInt(scanner.nextLine());
                                Helpers.library.decreaseNum(idcount,"count");
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }
                            break;
                        case 5:
                            if(!library.books.isEmpty()){
                                System.out.println("Enter book id");
                                int priceid=tryParseInt(scanner.nextLine());
                                Helpers.library.increaseNum(priceid,"price");
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }
                            break;
                        case 6:
                            if(!library.books.isEmpty()){
                                System.out.println("Enter Book Id");
                                int idprice=tryParseInt(scanner.nextLine());
                                Helpers.library.decreaseNum(idprice,"price");
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }

                            break;
                        case 7:
                            if(!library.books.isEmpty()){
                                int finish=0;
                                while (finish!=4 && finish<5 && !returnToManu){
                                    System.out.println("Search by 1.Name 2.Author 3.Language 4.Back to menu");
                                    String input=scanner.nextLine();
                                    int answer= tryParseInt(input);
                                    switch (answer){
                                        case 1:
                                            System.out.println("Please enter book name");
                                            String bookname=scanner.nextLine();
                                            library.findBook(bookname);
                                            break;
                                        case 2:
                                            System.out.println("Please enter book author");
                                            String bookauthor=scanner.nextLine();
                                            library.findBook(bookauthor);
                                            break;
                                        case 3:
                                            System.out.println("Please enter book language");
                                            String booklang=scanner.nextLine();
                                            library.findBook(booklang);
                                            break;
                                        case 4:
                                            returnToManu=true;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }

                            break;
                        case 8:
                            if(!library.books.isEmpty()){
                                Helpers.library.ShowBooks();
                                System.out.println("--------------------------------------------------");
                            }
                            else {
                            System.out.println("Your library is empty");
                            System.out.println("----------------------------------------------------");
                        }
                            break;
                        case 9:
                            int end=0;
                            if(!library.books.isEmpty()){
                                while (end!=6 && end<7 && !returnToManu){
                                    System.out.println("Update 1.Name 2.Author 3.Language 4.Count 5.Price 6.Back to menu");
                                    String input=scanner.nextLine();
                                    int answer= tryParseInt(input);
                                    switch (answer){
                                        case 1:
                                            System.out.println("Please enter book id");
                                            int bookid=tryParseInt(scanner.nextLine());
                                            System.out.println("Please enter new book name");
                                            String bookname=scanner.nextLine();
                                            library.updateBook(bookname,"name",bookid);
                                            break;
                                        case 2:
                                            System.out.println("Please enter book id");
                                            int bookid_=tryParseInt(scanner.nextLine());
                                            System.out.println("Please enter new book author");
                                            String bookauthor=scanner.nextLine();
                                            library.updateBook(bookauthor,"author",bookid_);
                                            break;
                                        case 3:
                                            System.out.println("Please enter book id");
                                            int _bookid=tryParseInt(scanner.nextLine());
                                            System.out.println("Please enter new book language");
                                            String booklang=scanner.nextLine();
                                            library.updateBook(booklang,"language",_bookid);
                                            break;
                                        case 4:
                                            System.out.println("Please enter book id");
                                            int book_id=tryParseInt(scanner.nextLine());
                                            System.out.println("Please enter new book count");
                                            String bookcount=scanner.nextLine();
                                            library.updateBook(bookcount,"count",book_id);
                                            break;
                                        case 5:
                                            System.out.println("Please enter book id");
                                            int _bookid_=tryParseInt(scanner.nextLine());
                                            System.out.println("Please enter new book price");
                                            String bookprice=scanner.nextLine();
                                            library.updateBook(bookprice,"price",_bookid_);
                                            break;
                                        case 6:
                                            returnToManu=true;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }
                            break;
                        case 10:
                            if(!library.books.isEmpty()){
                                library.deleteAllBook();
                                System.out.println("Successful");
                            }
                            else {
                                System.out.println("Your library is empty");
                                System.out.println("----------------------------------------------------");
                            }
                            break;
                        case 11:
                            System.out.println("Byeeeeeee");
                            return;
                        default:
                            break;
                    }

                }
                a=false;
            }

    }
}