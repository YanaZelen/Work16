package org.example;

import org.example.config.ApplicationConfig;
import org.example.config.DataSource;
import org.example.dao.PrototypeTest;
import org.example.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * DAO - слой отвечает за доступ к базам данных и другим внешним ресурсам. Объекты доступа к данным.
 * Только методы за работу с данными - сохранение, получение, обновление.
 * Нет бизнес логики.
 *
 * DTO - объект передачи данных. Некие POJO классы (Plaint old Java Object - это классы, которые созданы ТОЛЬКО для передачи
 * данных, у них есть только геттеры, сеттеры и конструкторы), которые относятся к конкретным данным.
 *
 * Service - классы сервисы, это прослойка между контролерами и дао
 *
 * Контролеры вызывают дао, дао вызывают сервисы Классы отвечающие за работу с запросами.
 *
 * IoC - Inversion of Control - Позволяет не беспокоится о том, где брать зависимости и данные.
 *
 * Dependency Injection - контейнеры Spring IoC
 * Реализация IoC
 * Один из контейнеров называется ApplicationContext. Это хранилище Бинов(объектов)
 * Из которого можно по его имени получить и применить нужный.
 *
 * Все что положили в спринг - бин. Любой объект под действием спринга - бин. По умолчанию - синглтон, сколько
 * ни вызывай - создается один объект.
 * Бин со скроуп prototype - будет создавать каждый раз новый объект.
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        
        CalcService calcService = new CalcService();
        System.out.println("Input first number");
        int num1 = scanner.nextInt();
        System.out.println("Input symbol");
        char symbol = scanner.next().charAt(0);
        System.out.println("Input second number");
        int num2 = scanner.nextInt();

        System.out.println(calcService.calculator(num1, symbol, num2));
    }

}
