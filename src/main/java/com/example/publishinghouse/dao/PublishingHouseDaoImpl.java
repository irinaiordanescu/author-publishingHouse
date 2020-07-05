package com.example.publishinghouse.dao;

import com.example.publishinghouse.HibernateUtil;
import com.example.publishinghouse.model.PublishingHouse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("publishingH")
public class PublishingHouseDaoImpl implements PublishingHouseDao {
    @Override
    public int insertPublishingHouse(PublishingHouse publishingHouse) { //post
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(publishingHouse);
            transaction.commit();
            return publishingHouse.hashCode();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PublishingHouse> selectAllPublishingHouses() { //get
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<PublishingHouse> publishingHouses = session.createQuery("from PublishingHouse ", PublishingHouse.class).getResultList();
            return publishingHouses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<PublishingHouse> selectPublishingHouseById(int id) { //get
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Optional<PublishingHouse> publishingHouse = session.createQuery("from PublishingHouse where idPublishingHouse = :idx", PublishingHouse.class).setParameter("idx", id).uniqueResultOptional();
            return publishingHouse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deletePublishingHouseById(int id) { //delete
        PublishingHouse publishingHouse = new PublishingHouse();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            publishingHouse = this.selectPublishingHouseById(id).get();
            session.delete(publishingHouse);
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
    public int updatePublishingHouseById(int id, String location) { //put
        PublishingHouse newLocation = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            newLocation = this.selectPublishingHouseById(id).get();
            newLocation.setLocation(location);
            session.update(newLocation);
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
