package lab;

// нужон класс книга
// нужон класс список книг
// нужон класс список авторов(который, возможно, наследуется от списка книг)
class Book {
    private String author;
    private String name;
    private int volume;

    public Book(String author, String name, int volume) {
        this.author = author;
        this.name = name;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return author + " «" + name + "». Объем: " + volume;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getName(String name) {
        this.name = name;
    }

    public void getVolume(int volume) {
        this.volume = volume;
    }


}
