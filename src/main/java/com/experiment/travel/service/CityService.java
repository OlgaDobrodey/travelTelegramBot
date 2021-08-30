package com.experiment.travel.service;

import com.experiment.travel.model.City;

import java.util.List;

public interface CityService {
    /**
     * Создает новый город
     * @param city - город для создания
     */
    void create(City city);

    /**
     * Возвращает список всех имеющихся городов
     * @return список городов
     */
    List<City> readAll();

    /**
     * Возвращает город по его ID
     * @param id - ID города
     * @return - объект города с заданным ID
     */
    City read(int id);

    /**
     * Возвращает город по его name
     * @param name - name города
     * @return - объект города с заданным name
     */
    City readForName(String name);

    /**
     * Обновляет города с заданным ID,
     * в соответствии с переданным городом
     * @param city - город в соответсвии с которым нужно обновить данные
     * @param id - id города которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(City city, int id);

    /**
     * Удаляет город с заданным ID
     * @param id - id города, которого нужно удалить
     * @return - true если город был удален, иначе false
     */
    boolean delete(int id);

}
