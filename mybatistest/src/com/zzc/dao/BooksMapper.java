package com.zzc.dao;

import com.zzc.domain.Books;

import java.util.List;

public interface BooksMapper {
    public Books findBoooksById(int uid);

    public void insertBooks(Books books);

    public void deleteBooksById(int uid);

    public List<Books> findBookByName(String name);

    public Books update(Books books);
}
