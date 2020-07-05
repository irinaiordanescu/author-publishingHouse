package com.example.publishinghouse.dao;

import com.example.publishinghouse.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    int insertAuthor(Author author); //post

    List<Author> selectAllAuthors(); //get

    Optional<Author> selectAuthorById(int id); //get

    Optional<Author> addAuthorToPublishingHouse(int idA, int idPH);

    List<Author> selectAllAuthorsByPublishingHouse(int idPH); //get

    int deleteAuthorById(int id); //delete

    int updateAuthorById(int id, int bookVersion); //put
}
