package Entities;

import Helpers.Helpers;

import javax.lang.model.element.Name;

public class Book {
    public String name;
    public String author;
    public String language;
    public String count;
    public String price;
    private int id;
    private static int _id;
    public Book(String Name,String Author,String Language,String Count, String Price){
        _id++;
        id=_id;
        name=Name;
        author=Author;
        language=Language;
        count=Count;
        price=Price;
    }

    public int getId(){
        return id;
    }



    public void fullInfo(){
        System.out.println("Id:"+ id + " Name:"+ name + " Author:" + author + " Language:" + language + " Count:" + count + " Price" +price);
    }





}
