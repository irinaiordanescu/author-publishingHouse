package com.example.publishinghouse.dao;

import com.example.publishinghouse.model.Author;
import com.example.publishinghouse.model.PublishingH;
import java.util.List;
import java.util.Optional;

public interface PublishingHDao {
    int insertPublishingHouse(PublishingH publishingH, Author author); //post

    List<PublishingH> selectAllPublishingHouses(); //get

    Optional<PublishingH> selectPublishingHouseById(); //get

    int deletePublishingHouseById(int id); //delete

    int updatePublishingHouseById(int id); //put
}
