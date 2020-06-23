package com.example.publishinghouse.model;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "bookVersion")
    private int bookVersion;

    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_idPublishingHouse")
    private PublishingH publishingH;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, int bookVersion, String category, PublishingH publishingH) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookVersion = bookVersion;
        this.category = category;
        this.publishingH = publishingH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBookVersion() {
        return bookVersion;
    }

    public void setBookVersion(int bookVersion) {
        this.bookVersion = bookVersion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PublishingH getPublishingH() {
        return publishingH;
    }

    public void setPublishingH(PublishingH publishingH) {
        this.publishingH = publishingH;
    }
}
