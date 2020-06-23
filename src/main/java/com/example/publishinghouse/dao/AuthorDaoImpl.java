package com.example.publishinghouse.dao;

import com.example.publishinghouse.model.Author;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public int insertAuthor(Author author) {
        return 0;
    }

    @Override
    public List<Author> selectAllAuthors() {
        return null;
    }

    @Override
    public Optional<Author> selectAuthorById() {
        return Optional.empty();
    }

    @Override
    public List<Author> getAuthorsByPublishingH(int idPublishingH) {
        return null;
    }

    @Override
    public List<Author> getAuthorsFromSamePublishingH(int id) {
        return null;
    }

    @Override
    public int deleteAuthorById(int id) {
        return 0;
    }

    @Override
    public int updateAuthorById(int id) {
        return 0;
    }
}
