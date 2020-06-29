package dao;

import java.io.FileNotFoundException;
import java.io.IOException;

/***
 * Interfejs umo�liwiaj�cy komunikacje z �r�d�em danych.
 * Zawiera metody odpowiedzialne za odczytywanie i zapisywanie plik�w.
 * @param <T> Typ objektu do zapisu b�d� odczytu.
 */

public interface Dao<T> {

    T read() throws IOException;

    void write(T obj) throws IOException;

}