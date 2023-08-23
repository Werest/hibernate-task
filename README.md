# Домашнее задание к занятию «8.4. ORM, Hibernate»

# Задача «Слой DAO c Hibernate»

## Описание

Попрактикуемся в работе с Hibernate через Spring, параллельно закрепляя уже пройденные темы.

Вам надо написать приложение для работы с БД, используя средства Spring по конфигурации и работе с Hibernate, адаптировав таблицы из задания [«Таблица пользователей»](../../sql-basic/task/README.md).

**Что нужно сделать**

1. Создайте Spring Boot приложение с зависимостями на два стартера — `spring-boot-starter-data-jpa` и `spring-boot-starter-web`.

2. Создайте Entity, которая соответствует таблице из условий задачи [«Таблица пользователей»](../../sql-basic/task/README.md).

3. Напишите репозиторий для работы с БД.

- создайте класс и пометьте его аннотацией Repository, либо создайте бин репозитория в Java Config классе;
- правильно инжектируйте EntityManager;
- создайте метод `getPersonsByCity(String city)`, который будет принимать название города и возвращать ваше Entity из базы данных, соответствующие этому `city`. Сделать это можно, например, получив всех пользователей и отфильтровав их по городу.

4. Напишите контроллер с методом-обработчиком GET-метода запроса с маппингом на endpoint `/persons/by-city`. В query params запроса будет приходить строковый параметр `city`, который вам надо будет передавать дальше в репозиторий. То есть, ваш метод должен уметь обрабатывать запрос вида `localhost:8080/persons/by-city?city=Moscow`.
   Контроллер должен будет возвращать всех людей, которых он получит от репозитория.

5. Написанные код выложите в отдельный репозиторий на GitHub и прикрепите ссылку на него в комментарий к домашнему заданию.

# Задача «Две таблицы с Hibernate*» (задача со звёздочкой)

## Описание

Эта задача необязательная, её выполнение не влияет на получение зачёта.

Перепишем приложение из [задания по JDBC](../../jdbc/task1/README.md) на Hibernate.

1. Нужно написать две `Entity`, соответствующие двум таблицам из задания. Учтите, что вам надо верно выбрать логику отношений этих `Entity`: `OneToOne`, `OneToMany`, `ManyToOne`, `ManyToMany`.

2. Перепишите репозиторий, чтобы он работал с `EntityManager`, а не через `NamedParameterJdbcTemplate`.

3. Написанный код выложите в тот же репозиторий, что и для задачи [«Слой DAO (Data Access Object)»](../../jdbc/task1/README.md) на GitHub, только создайте под него другую ветку `hibernate` и прикрепите ссылку на неё в комментарий к домашнему заданию.

# Задача «Миграции c Hibernate*» (задача со звёздочкой)

## Описание

Эта задача необязательная, её выполнение не влияет на получение зачёта.

Настало время попрактиковаться в работе с механизмами миграции в Hibernate.

**Что нужно сделать**

1. Адаптируйте логику работы задания [«Слой DAO c Hibernate»](../task1/README.md) так, чтобы ваше приложение работало одновременно и с миграциями, и с Hibernate. Не важно, выберете вы Flyway или Liquibase.

3. Написанный код выложите в тот же репозиторий, что и для первой задачи [«Слой DAO c Hibernate»](../task1/README.md) на GitHub, только создайте под него другую ветку `migration-hibernate` и прикрепите ссылку на неё в комментарий к домашнему заданию.