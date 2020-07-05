package com.example.publishinghouse.dao;

import com.example.publishinghouse.model.PublishingHouse;
import java.util.List;
import java.util.Optional;

public interface PublishingHouseDao {
    int insertPublishingHouse(PublishingHouse publishingHouse); //post

    List<PublishingHouse> selectAllPublishingHouses(); //get

    Optional<PublishingHouse> selectPublishingHouseById(int id); //get

    int deletePublishingHouseById(int id); //delete

    int updatePublishingHouseById(int id, String location); //put

    //o noua ruta pe /{idPublishing}/addAuthor/{idAuthor}
    // cu o functie addAutorToPublishingHouse care face legatura
    // vezi licenta
    //List<...> addAuthorToPublishingHouse(int idA, int idPH)
}
