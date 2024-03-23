package com.example.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.Model.Book;
import com.example.Model.User;

public class LibraryApp {
    
    Map<Integer, ArrayList<Book> > userToBooks;
    Map<Integer, Integer> bookToReturnDate;

    public LibraryApp(){
        this.userToBooks = new HashMap<>();
        this.bookToReturnDate = new HashMap<>();
    }

    public void createRecord(User user, ArrayList<Book> books, Integer date){
        ArrayList<Book> booksUser = userToBooks.get(user.getId())!=null?userToBooks.get(user.getId()):new ArrayList<Book>();
        for(int i=0;i<books.size();i++){
            booksUser.add(books.get(i));
            bookToReturnDate.put(books.get(i).getId(), date);
        }
        userToBooks.put(user.getId(), booksUser);
        printBooksForUser(user);
    }

    public ArrayList<Book> printBooksForUser(User user){
        for(int i=0;i<userToBooks.get(user.getId()).size();i++){
            System.out.println(" books = "+userToBooks.get(user.getId()).get(i).getId());
        }
        return userToBooks.get(user.getId());
    }

    public ArrayList<Book> returnBooksForUser(User user, Integer date){
        ArrayList<Book> returnBooks = new ArrayList<>();
        ArrayList<Book> remainingBooks = new ArrayList<>();
        for(int i=0;i<userToBooks.get(user.getId()).size();i++){
            if(bookToReturnDate.get(userToBooks.get(user.getId()).get(i).getId())<=date){
                System.out.println(userToBooks.get(user.getId()).get(i).getId());
                returnBooks.add(userToBooks.get(user.getId()).get(i));
            }
            else{
                remainingBooks.add(userToBooks.get(user.getId()).get(i));
            }
        }
        userToBooks.put(user.getId(), remainingBooks);
        return returnBooks;
    }
}
