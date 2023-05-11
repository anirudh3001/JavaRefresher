package Comparable_Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private Integer yearPublished;

    @Override
    public int compareTo(Book b) {
        return this.yearPublished - b.getYearPublished();
    }

    public static void  main(String args[]){
        ArrayList<Book> list
                = new ArrayList<Book>();

        list.add(new Book("Harry Potter","JK Rowling",1999));
        list.add(new Book("Harry Potter","JK Rowling",2012));
        list.add(new Book("To Kill a Mockingbird","Harper Lee",1975));


        Collections.sort(list);

        // Displaying data
        for (Book book : list)
            System.out.println(book.toString());
    }
}

