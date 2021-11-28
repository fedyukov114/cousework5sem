package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.People;

import java.util.List;

public interface PeopleService {
    /*
        Создает нового студента
     */
    void create(People people);

    /*
        Возвращает список всех существующих студентов
     */
    List<People> readAll();

    /*
        Возвращает определенного студента
     */
    People read(int id);

    /*
        Обновляет информацию об определенном студенте
     */
    boolean update(People people, int id);

    /*
        Удаляет определенного студента
     */
    boolean delete(int id);
}
