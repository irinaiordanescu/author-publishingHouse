package com.example.publishinghouse.dao;

import com.example.publishinghouse.model.Author;
import com.example.publishinghouse.model.PublishingH;
import java.util.List;
import java.util.Optional;

public class PublishingHDaoImpl implements PublishingHDao {
    @Override
    public int insertPublishingHouse(PublishingH publishingH, Author author) {
        return 0;
    }

    @Override
    public List<PublishingH> selectAllPublishingHouses() {
        return null;
    }

    @Override
    public Optional<PublishingH> selectPublishingHouseById() {
        return Optional.empty();
    }

    @Override
    public int deletePublishingHouseById(int id) {
        return 0;
    }

    @Override
    public int updatePublishingHouseById(int id) {
        return 0;
    }
}
