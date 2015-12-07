package ua.luckydev.zadachki.SingleList;

/**
 * Created by Lucky on 28.11.2015.
 */

//главный класс
public class InvertList
{

    public static void main(String[] args)

    {
        SingleList singList = new SingleList();

        singList.add(1); //добавояем элементы в список
        singList.add(2);
        singList.add(3);
        singList.add(4);
        singList.add(5);

        ListElement currentElement = singList.head;

        while(currentElement!=null) // проходимся по списку и выводим на экран элементы пока не дойдём до посдеднего элемента
        {
            System.out.println(currentElement);
            currentElement=currentElement.nextElement;
        }

        System.out.println("*****");

        singList = invert(singList); // инвертируем список

        currentElement = singList.head;
        System.out.println("*****");

        while(currentElement!=null) //выводим список на экран после инверсии
        {
            System.out.println(currentElement);
            currentElement=currentElement.nextElement;
        }
    }

    public static SingleList invert(SingleList singList) //непосредственно инверсия
    {
        ListElement element = singList.head; // сохраняем голову в переменной
        singList.head = singList.tail; // хвост переносим в голову
        ListElement currentElement = singList.head;
        singList.tail.nextElement = element; //меняем ссылку у ЕКС хвоста на новую
        singList.tail = findTail(currentElement, singList.tail); //ищем новый  хвост в связи с тем, что старый не актуальный

        while (element != singList.tail) // проходимся до тех пор пока первоночальная голово не станет хвостом
        {
            singList.tail.nextElement = currentElement.nextElement; //меняем ссылку у ЕКС хвоста на новую
            currentElement.nextElement = singList.tail; //ставим ссылку на ЭКС хвост у предыдущего элемента (currentElement)
            currentElement = singList.tail; // определяем новый текущий элемент
            singList.tail = findTail(currentElement, singList.tail); //ищем новый хвост
        }

        singList.tail.nextElement = null;

        return singList;
    }


    public static ListElement findTail(ListElement el, ListElement tail) //поик нового хвоста
    {
        while (el.nextElement != tail) // проходимся пока предыдущий элемент не будет ссылаться на ЕКС хвост
                                       // назначаем хвостом предыдущий элемент
        {
            el = el.nextElement;
        }

        return el;
    }
}
