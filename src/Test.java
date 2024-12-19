import lab.*;

public class Test {
    public static void main(String[] args) {
        // тут скоро появятся тесты

        // Создадим пустой список литературы без ограничений по размеру
        BookList Firstbooklist = new BookList();
        // Создадим пустой список литературы с ограничением (size > 0) по размеру
        BookList SecondbookList = new BookList(4);
        // Пустой список
        BookList ThirdbookList = new BookList();


        // Создадим книги
        Book book1 = new Book("Михаил Афанасьевич Булгаков", "Собачье сердце", 384);
        Book book2 = new Book("Антон Павлович Чехов", "Дядя Ваня", 38);
        Book book3 = new Book("Евгений Валерьевич Гришковец", "Водка как нечто большее", 70);
        Book book4 = new Book("Екатерина Алексеевна Авдеева", "Поваренная книга русской опытной хозяйки. Заготовки", 224);
        Book book5 = new Book("Венедикт Васильевич Ерофеев", "Москва — Петушки", 192);
        Book book6 = new Book("Антон Павлович Чехов", "Вишневый сад", 320);

        // Добавим эти книги в список 1 и список 2
        Firstbooklist.addBook(book6);
        Firstbooklist.addBook(book2);
        Firstbooklist.addBook(book3);
        Firstbooklist.addBook(book4);
        Firstbooklist.addBook(book5);
        // добавим книгу, которая там уже лежит
        Firstbooklist.addBook(book1);

        // Аналогично в список 2
        SecondbookList.addBook(book1);
        SecondbookList.addBook(book2);
        SecondbookList.addBook(book3);
        SecondbookList.addBook(book4);
        // Добавим книгу в переполненный список (программа выведет предупреждение)
        SecondbookList.addBook(book5);

        // Списки книг созданы и заполнены, можно вывести их на экран
        System.out.println(Firstbooklist);
        System.out.println();
        System.out.println(SecondbookList);
        System.out.println();
        System.out.println(ThirdbookList);
        System.out.println();

        // Подсчитать объем книг автора
        System.out.println(Firstbooklist.authorCount("Венедикт Васильевич Ерофеев"));
        System.out.println(SecondbookList.authorCount("Антон Павлович Чехов"));
        // Вводим автора, которого нет в списке
        System.out.println(Firstbooklist.authorCount("Unkhown"));
        // Поиск в пустом списке
        System.out.println(ThirdbookList.authorCount("Михаил Афанасьевич Булгаков"));
        System.out.println();

        // Создание списка авторов(происходит на основе списка книг и никак иначе)
        AuthorList FirstauthorList = new AuthorList(Firstbooklist);
        AuthorList SecondauthorList = new AuthorList(SecondbookList);
        AuthorList ThirdauthorList = new AuthorList(ThirdbookList);
        // Вывод данных об авторах
        System.out.println(FirstauthorList);
        System.out.println();
        System.out.println(SecondauthorList);
        System.out.println();
        System.out.println(ThirdauthorList);
        System.out.println();

        // Средний объем книги в списке(применимо только к спискам)
        System.out.println(Firstbooklist.averageVolume());
        System.out.println(SecondbookList.averageVolume());
        System.out.println(ThirdbookList.averageVolume());
        System.out.println();

        // Средний объем книг автора
        System.out.println(Firstbooklist.averageVolumeOfAuthor("Михаил Афанасьевич Булгаков")); // безразмерный список
        System.out.println(SecondbookList.averageVolumeOfAuthor("Екатерина Алексеевна Авдеева")); // размерный список
        System.out.println(ThirdbookList.averageVolumeOfAuthor("Евгений Валерьевич Гришковец")); // пустой список
        System.out.println(Firstbooklist.averageVolumeOfAuthor("Unkhown")); // Неизвестный запрос
        // То же самое, но на списках авторов
        System.out.println(FirstauthorList.averageVolumeOfAuthor("Михаил Афанасьевич Булгаков"));
        System.out.println(SecondauthorList.averageVolumeOfAuthor("Екатерина Алексеевна Авдеева"));
        System.out.println(ThirdauthorList.averageVolumeOfAuthor("Екатерина Алексеевна Авдеева"));
        System.out.println(FirstauthorList.averageVolumeOfAuthor("Unkhown"));
        System.out.println();

        // Поиск автора с наибольшим вкладом
        // Проверка на списке без размера
        System.out.println(Firstbooklist.MostContributions("Book"));
        System.out.println(Firstbooklist.MostContributions("Page"));
        System.out.println();
        // Проверка на списке с размером
        System.out.println(SecondbookList.MostContributions("Book"));
        System.out.println(SecondbookList.MostContributions("Page"));
        System.out.println();
        // Проверка на пустом списке
        System.out.println(ThirdbookList.MostContributions("Book"));
        System.out.println(ThirdbookList.MostContributions("Page"));
        System.out.println();
        // То же самое, но на списках авторов
        System.out.println(FirstauthorList.MostContributions("Book"));
        System.out.println(FirstauthorList.MostContributions("Page"));
        System.out.println();
        System.out.println(SecondauthorList.MostContributions("Book"));
        System.out.println(SecondauthorList.MostContributions("Page"));
        System.out.println();
        System.out.println(ThirdauthorList.MostContributions("Book"));
        System.out.println(ThirdauthorList.MostContributions("Page"));
        System.out.println();

        // Сравнение лидеров по количеству книг и страниц
        System.out.println(Firstbooklist.ComparisonOfLeaders());
        System.out.println();
        System.out.println(SecondbookList.ComparisonOfLeaders());
        System.out.println();
        System.out.println(ThirdbookList.ComparisonOfLeaders());
        System.out.println();
        System.out.println(FirstauthorList.ComparisonOfLeaders());
        System.out.println();
        System.out.println(SecondauthorList.ComparisonOfLeaders());
        System.out.println();
        System.out.println(ThirdauthorList.ComparisonOfLeaders());

    }
}


