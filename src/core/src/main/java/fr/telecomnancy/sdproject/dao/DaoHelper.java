package fr.telecomnancy.sdproject.dao;

/**
 * @author Zakaria BENJEBARA.
 */
public interface DaoHelper<T, N extends Number> {

    T insert(T data);

    void remove(N id);

    void remove(T data);

    void remove(Iterable<? extends T> datas);

    T update(T data);

    T find(N id);

    Iterable<T> findAll();
}
