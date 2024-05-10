<h1 align = "center">Лабораторна робота 7(18)</h1>
<h2>Тема: Потоки</h2>
<div>
Завдання:
1
пошук файлів(наприклад *. txt чи *. mp3 і т. д.) в к-кох потоках, у вказаному місці разом з пошуком у підкаталогах. Для кожного каталога запускати новий потік

2
текстовий редактор. Забезпечити збереження файлів разом з їх резервними копіями(к-ть копій та їх місце розташування задає користувач). Оригінал та кожна копія зберігаються в окремому потоці.

3.
Перегони для потоків. Організувати перегони для N потоків. Передбачити к-ть потоків, приорітети та відображення перших 3 переможців. Достроково завершити решту потоків після перших 3х переможців.

4.
Створити програму яка здійснює сортування N кількості масивів, заповнених випадковими значеннями. Сортування кожного масиву відбувається в окремому потоці.
Просортовані масиви об’єднати в рамках одного великого масиву, який потім теж потрібно просортувати.
*для сортування використовувати реалізацію будь якого класичного метода сортування (бульбашка, вставки і т.д.).

/////// підвищена складність ////
5.
Мінігра де гравця атакує відразу група ботів(можна без графіки, тільки текстові повідомлення). Кожен бот працює в окремому потоці. Для інтерфейсу використати Swing/FX.

6.
Створити програму що відображатиме статистику відвідувань певного сайту на основі даних з БД. (файл 18_site_visitors.sql)
Статистика повинна надавти інформацію про:
- загальну кількість унікальних відвідувачів за весь період
- загальну кількість усіх переглядів за весь час
- кількість відівідувачів за добу
- кількість переглядів за добу
- розподіл браузерів за добу та весь період (можна визначати приблизно на підставі даних у полі 'ua' )
- розподіл по пристроях за добу та весь період (можна визначати приблизно на підставі даних у полі 'ua')
- розподіл по операційних системах (можна визначати приблизно на підставі даних у полі 'ua')



Інтерфейс Java Swing/FX.( для всіх варіантів )
** Продемонструвати роботу програми з використанням потоків так і без створення потоків. (для більшого ефекту можна продублювати к-ка разів наявні дані в таблиці)


Варіант по списку

Для всіх варіантів:
Оформити звіт.
Проект з вихідним кодом, документацію та звіт загрузіть сюди ( архів і гугл диск ) або посилання на GIT ( звіт в Readme.md, посилання на репозиторій ).
</div>
<div>
  <h4>Хід виконання</h4>
  <ol>
    <li>Продумовую що саме хочу зробити</li>
    <li>Обдумовую можливі помилки</li>
    <li>Пишу код, перевіряю на виникнення помилок</li>
    <li>Пишу звіт</li>
  </ol>
  <div>
    <h4>Скріншоти роботи програми</h4>
    <div>
<img width="322" alt="image" src="https://github.com/maksympalchei/lab7/assets/148455517/e723844f-140d-4d6b-a71e-97c6dcec9d40">
<img width="314" alt="image" src="https://github.com/maksympalchei/lab7/assets/148455517/0892b64b-0526-4290-8f74-35fb1e3927da">
<img width="631" alt="image" src="https://github.com/maksympalchei/lab7/assets/148455517/57b32a7e-a219-439f-9449-ae659717c4d8">
    </div>
  </div>
</div>
<div>
  <h4>Висновки:</h4>
  На  цій лабораторній роботі ми попрактикувались у використанні потоків для оптимізації виконання програми і ефективнішого ропзоділу ресурсів
</div>
