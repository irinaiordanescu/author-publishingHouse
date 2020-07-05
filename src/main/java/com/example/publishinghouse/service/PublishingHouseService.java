package com.example.publishinghouse.service;

import com.example.publishinghouse.dao.PublishingHouseDao;
import com.example.publishinghouse.model.PublishingHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublishingHouseService {
    private static PublishingHouseDao publishingHouseDao = null;

    @Autowired
    public PublishingHouseService(@Qualifier("publishingH") PublishingHouseDao publishingHouseDao) {
        this.publishingHouseDao = publishingHouseDao;
    }

    public int addPublishingHouse(PublishingHouse publishingHouse) {
        return publishingHouseDao.insertPublishingHouse(publishingHouse);
    }

    public List<PublishingHouse> getAllPublishingHouses() {
        return publishingHouseDao.selectAllPublishingHouses();
    }

    public static Optional<PublishingHouse> getPublishingHouseById(int id) {
        return publishingHouseDao.selectPublishingHouseById(id);
    }

    public int deletePublishingHouseById(int id) {
        return publishingHouseDao.deletePublishingHouseById(id);
    }

    public int updatePublishingHouseById(int id, String locationToUpdate) {
        return publishingHouseDao.updatePublishingHouseById(id, locationToUpdate);
    }
}
