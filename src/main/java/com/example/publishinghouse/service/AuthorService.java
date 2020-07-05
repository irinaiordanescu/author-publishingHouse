package com.example.publishinghouse.service;

import com.example.publishinghouse.dao.AuthorDao;
import com.example.publishinghouse.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(@Qualifier("author") AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public int addAuthor(Author author) {
        return authorDao.insertAuthor(author);
    }

    public List<Author> getAllAuthors() {
        return authorDao.selectAllAuthors();
    }

    public Optional<Author> getAuthorById(int id) {
        return authorDao.selectAuthorById(id);
    }

    public Optional<Author> addAuthorToPublishingHouse(int idA, int idPH) {
        return authorDao.addAuthorToPublishingHouse(idA, idPH);
    }

    public List<Author> getAllAuthorsByPublishingHouse(int idPH) {
        return authorDao.selectAllAuthorsByPublishingHouse(idPH);
    }

    public int deleteAuthorById(int id) {
        return authorDao.deleteAuthorById(id);
    }

    public int updateAuthorById(int id, int bookVersionToUpdate) {
        return authorDao.updateAuthorById(id, bookVersionToUpdate);
    }
}
