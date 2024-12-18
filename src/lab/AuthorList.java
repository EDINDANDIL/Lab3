package lab;

// п.5 создание списка авторов
public class Author {

    private String author;
//    private int count; // параметр
//    private int pageCount; // параметр
    public String[][] arr; // тут храним данные непосредственно списка авторов
//    private int cnt; // кол-во авторов
    public String[] surnames;

    public Author(BookList arg) {
        // в этот момент надо создать массив уникальных имен, создать двумерный массив с этими именами,
        // пробежаться по списку имен и одновременно по списку книг, добавляя по имени значения


        // вот тут происходит создание списка уникальных фамилий
        if (arg.getList() != null) {

            surnames = new String[]{arg.getList()[0].getAuthor()}; // Если список книг не пуст, то смело ставим первую
            // фамилию на первое место

            for (int i = 1; i < arg.getList().length; i++) {
                boolean flag = false; // arr[i] не находится в списке уникальном

                for (int j = 0; j < this.surnames.length; j++) {

                    if (arg.getList()[i].getAuthor().equals(this.surnames[j])) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {

                    String[] temp = this.surnames;
                    this.surnames = new String[temp.length + 1];
                    for (int x = 0; x < temp.length; x++) {
                        this.surnames[x] = temp[x];
                    }
                    this.surnames[temp.length] = arg.getList()[i].getAuthor();
                }
            }

            arr = new String[surnames.length][3]; // Фамилия/кол-во книг/объем

            // тут заполняю итоговый массив фамилиями
            for (int p = 0; p < surnames.length; p++) {
                arr[p][0] = surnames[p];
                arr[p][1] = 0 + "";
                arr[p][2] = 0 + "";
            }

            // теперь надо создать непосредственно список авторов и их кол-во книг/страниц
            for (int index = 0; index < arr.length; index++) {

                for (int j = 0; j < arg.getList().length; j++) {

                    if (arr[index][0].equals(arg.getList()[j].getAuthor())) {
                        arr[index][1] = (Integer.parseInt(arr[index][1]) + 1) + "";
                        arr[index][2] = (Integer.parseInt(arr[index][2]) + arg.getList()[j].getVolume()) + "";
                    }
                }
            }
        }
    }

    // п.6 вывод списка авторов
    @Override
    public String toString(){
        if(this.arr == null){
            return "Список пуст !";
        }else{
            StringBuilder ans = new StringBuilder();

            int num = 1;
            for (int i = 0; i < this.arr.length; i ++) {

                if(this.surnames.length == num){
                    ans.append(num + ". Автор: " + this.arr[i][0] + ". Количество книг: " + this.arr[i][1] + ". Объем страниц: " + this.arr[i][2]+".");
                    num++;
                }else{
                    ans.append(num + ". Автор: " + this.arr[i][0] + ". Количество книг: " + this.arr[i][1] + ". Объем страниц: " + this.arr[i][2]+".").append("\n");
                    num++;
                }


            }
            return ans.toString();

        }
    }



}
