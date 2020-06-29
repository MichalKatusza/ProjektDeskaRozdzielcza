package dao;

import java.io.FileNotFoundException;
import java.io.IOException;

/***
 * Interfejs umo¿liwiaj¹cy komunikacje z Ÿród³em danych.
 * Zawiera metody odpowiedzialne za odczytywanie i zapisywanie plików.
 * @param <T> Typ objektu do zapisu b¹dŸ odczytu.
 */

public interface Dao<T> {

    T read() throws IOException;

    void write(T obj) throws IOException;

}