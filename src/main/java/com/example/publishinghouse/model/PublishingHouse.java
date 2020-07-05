package com.example.publishinghouse.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishinghouse")
public class PublishingHouse {
    @Id
    @GeneratedValue
    @Column(name = "idPublishingHouse")
    private int idPublishingHouse;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @ManyToMany(mappedBy = "publishingHs")
    @Fetch(FetchMode.JOIN)
    private Set<Author> authors = new HashSet<>();

    public PublishingHouse() {
    }

    public PublishingHouse(int idPublishingHouse, String name, String location, Set<Author> authors) {
        this.idPublishingHouse = idPublishingHouse;
        this.name = name;
        this.location = location;
        this.authors = authors;
    }

    public int getId() {
        return idPublishingHouse;
    }

    public void setId(int idPublishingHouse) {
        this.idPublishingHouse = idPublishingHouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author a) {
        this.authors.add(a);
    }
}
