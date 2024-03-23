package com.example;

import java.util.ArrayList;

import com.example.Model.Book;
import com.example.Model.User;
import com.example.Service.LibraryApp;

public class Main {
    public static void main(String[] args) {
        
        LibraryApp libraryApp = new LibraryApp();
        User user = new User(5);
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book(6);
        Book book2 = new Book(7);
        Book book3 = new Book(3);
        Book book4 = new Book(2);
        Book book5 = new Book(9);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        libraryApp.createRecord(user, books, 10);
        ArrayList<Book> books1 = new ArrayList<>();
        Book book6 = new Book(19);
        Book book7 = new Book(21);
        Book book8 = new Book(20);
        books1.add(book6);
        books1.add(book7);
        books1.add(book8);
        libraryApp.createRecord(user, books1, 5);
        libraryApp.returnBooksForUser(user, 9);
    }
}