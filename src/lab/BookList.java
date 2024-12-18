package lab;

// п.1 создание списка
class BookList {

    private Book[] list;
    private int size;
    private int cnt;

    public BookList() {
        this.size = -1; // это граница, которая может лежать на (0; +беск)
        this.cnt = 0;
    }

    public BookList(int size) {
        this.size = size;
        this.cnt = 0;
        this.list = new Book[size];
    }

    public Book[] getList() {
        return this.list;
    }

    public void addBook(Book arg) {

        if (this.size < 0) {

            Book[] temp = this.list;
            this.list = new Book[this.cnt + 1];

            // скопировали(если temp не пуст)
            if (temp != null) {
                for (int i = 0; i < temp.length; i++) {
                    this.list[i] = temp[i];
                }
            }

            // проверка на наличие такой книги
            boolean flag = false;
            for (int i = 0; i < this.list.length; i++) {
                if (this.list[i] == arg) flag = true;
            }

            if (!flag) {
                // на последнее место поставили
                this.list[this.cnt] = arg;
                this.cnt += 1;
            }


        } else {
            if (this.list[this.cnt] == null && this.cnt != this.size) {
                this.list[this.cnt] = arg;
                this.cnt += 1;
            }
        }
    }

    // п.2 вывод списка книг
    @Override
    public String toString() {
        if (this.cnt == 0) {
            return "Список пуст";
        } else {
            StringBuilder ans = new StringBuilder();
            int num = 1;
            for (Book i : this.list) {
                ans.append(num + ". " + i).append("\n");
                num++;
            }
            return ans.toString();
        }
    }

    // п.3 подсчет кол-ва книг
    public String authorCount(String author) {
        if (this.list == null) {
            return "Такого автора не нашлось";
        } else {

            int ans = 0;

            for (int i = 0; i < this.list.length; i++) {
                if (this.list[i].getAuthor().equals(author)) {
                    ans++;
                }
            }

            if (ans == 0) {
                return "Такого автора не нашлось";
            } else {
                return "По данному автору нашлось книг: " + ans;
            }

        }
    }

    // п.4 подсчет объема по автору
    public String authorvolumeCount(String author) {
        if (this.list == null) {
            return "Такого автора не нашлось";
        } else {

            int ans = 0;

            for (int i = 0; i < this.list.length; i++) {
                if (this.list[i].getAuthor().equals(author)) {
                    ans += this.list[i].getVolume();
                }
            }

            if (ans == 0) {
                return "Такого автора не нашлось";
            } else {
                return "Объем по данному автору составляет: " + ans;
            }

        }
    }
}
