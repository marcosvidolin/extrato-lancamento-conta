package com.marcosvidolin.sbapi.mapper;

/**
 * The Mapable interface defines a mapper behavior.
 *
 * @param <T> type of the object to be converted into
 * @param <S> type of the original object
 */
public interface Mapable<T, S> {

    /**
     * Converts the object to the given type.
     *
     * @param s
     * @return
     */
    T map(S s);
}
