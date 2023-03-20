package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;


/*
Задача:
Задание в целом не такое сложное. Вам необходимо взять ваше приложение калькулятор и написать для него тесты.

Для этого надо соблюсти следующие правила:

Реализацию вашего калькулятора через консоль нужно вывести в отдельный класс org.example.CalcService и там уже его реализовывать
В классе Main будет только использование уже готового сервиса CalсService
Ошибки, которые вы обрабатываете в калькуляторе не должны съедаться. Надо их обработать, вывести в консоль,
что произошла такая-то ошибка и пробросить её дальше через throw. Это нужно, чтоб написать тест на вывод ошибки
Вы должны написать минимум 4 теста
Тест на успешный подсчёт
Тест на неверные значения
Тест деления на 0
Тест выбрасывания ошибки (этот тест должен именно ожидать ошибку. Пример на уроке я показывал)
Экземпляр класса org.example.CalcService для теста должен создаваться в специальном методе @Before

Задание со звёздочкой
Возьмите ваш недавний сервис по копированию файла и напишите для него тесты
Условия следующие:
Перепишите вашу логику так, чтоб она была реализована в отдельном классе CopyFileService и уже внутри него вся реализация
В метод копирования потоки ввода вывода должны получаться из вне. Тобишь в метод придет путь до файла, поток ввода,
потов вывода (это нужно для примера с тестами)
Метод логирования вызывается в методе копирования и получает все данные от него
Надо написать следующие тесты:
Тест успешного копирования
Тест когда поток был прерван и вышла ошибка (именно поэтому мы выносим потоки во вне)
Тест когда был передан неверный путь до файла
У класса теста должны быть методы @Before и @After в которых создаются потоки и закрываются

 */

public class CalcService {

    public int calculator(int num1, char symbol, int num2) {

        try {
            switch (symbol) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return  num1 * num2;
                case '/':
                    if(num2 == 0) {
                        throw new ArithmeticException("Sorry, you cant divide by zero");
                    }
                    return  num1 / num2;
                default:
                    throw new InputMismatchException("Sorry, I can't do this :0 Please, input a NUMBER and a +, -, * or /");
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }


    }
}
