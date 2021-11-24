package model;

public class Books {

    private int id;
    private String title;
    private String author;
    private int year;
    private int pages;

    public Books(int Id, String Title, String Author, int Year, int Pages){
        this.id = Id;
        this.title=Title;
        this.author = Author;
        this.year=Year;
        this.pages=Pages;
    }

    public Books() {

    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
