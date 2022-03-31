package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int pagesCount;
    private final int ISBN;

    public Book(String name, String author, int pagesCount, int nISBN, String name1, String author1, int pagesCount1, int nISBN1) {
        this.name = name;
        this.author = author;
        this.pagesCount = pagesCount;
        this.ISBN = nISBN;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getISBN() {
        return ISBN;
    }

}
