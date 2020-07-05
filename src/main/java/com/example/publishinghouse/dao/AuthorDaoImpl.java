package com.example.publishinghouse.dao;

import com.example.publishinghouse.HibernateUtil;
import com.example.publishinghouse.model.Author;
import com.example.publishinghouse.model.PublishingHouse;
import com.example.publishinghouse.service.PublishingHouseService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("author")
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public int insertAuthor(Author author) { //post
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            return author.hashCode();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Author> selectAllAuthors() { //get
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Author> authors = session.createQuery("from Author ", Author.class).getResultList();
            return authors;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Author> selectAuthorById(int id) { //get
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Optional<Author> author = session.createQuery("from Author where idAuthor = :idx", Author.class).setParameter("idx", id).uniqueResultOptional();
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Author> addAuthorToPublishingHouse(int idA, int idPH) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Author author = selectAuthorById(idA).get();
            PublishingHouse publishingHouse = PublishingHouseService.getPublishingHouseById(idPH).get();
            author.addPublishingHouse(publishingHouse);
//            publishingHouse.addAuthor(author);
            session.update(author);
//            session.update(publishingHouse);
            return Optional.of(author);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Author> selectAllAuthorsByPublishingHouse(int idPH) { //get
        return null;
    }

    @Override
    public int deleteAuthorById(int id) { //delete
        Author author = new Author();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            author = this.selectAuthorById(id).get();
            session.delete(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAuthorById(int id, int bookVersion) { //put
        Author newBookVersion = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            newBookVersion = this.selectAuthorById(id).get();
            newBookVersion.setBookVersion(bookVersion);
            session.update(newBookVersion);
            transaction.commit();
        } catch (Error e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }
}
