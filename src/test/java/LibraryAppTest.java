import org.junit.Test;

import com.example.Model.Book;
import com.example.Model.User;
import com.example.Service.LibraryApp;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class LibraryAppTest {

    @Test
    public void testPerson() {
         
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
        libraryApp.createRecord(user, books, 10);
        ArrayList<Book> booksNew = new ArrayList<>();
        booksNew.add(book4);
        booksNew.add(book5);
        libraryApp.createRecord(user, booksNew, 17);
        ArrayList<Book> returnBooks = libraryApp.returnBooksForUser(user, 12);
        assertEquals(3, returnBooks.size());
        assertTrue(returnBooks.contains(book1));
        assertTrue(returnBooks.contains(book2));
        ArrayList<Book> remainingBooks = libraryApp.printBooksForUser(user);

        assertEquals(2, remainingBooks.size());
        assertTrue(remainingBooks.contains(book4));
        assertTrue(remainingBooks.contains(book5));
    }
}
