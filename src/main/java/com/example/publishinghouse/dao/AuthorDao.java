package com.example.publishinghouse.dao;

import com.example.publishinghouse.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    int insertAuthor(Author author); //post

    List<Author> selectAllAuthors(); //get

    Optional<Author> selectAuthorById(); //get

    List<Author> getAuthorsByPublishingH(int idPublishingH);

    List<Author> getAuthorsFromSamePublishingH(int id);

    int deleteAuthorById(int id); //delete

    int updateAuthorById(int id); //put
}
