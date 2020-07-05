package com.example.publishinghouse.api;

import com.example.publishinghouse.model.Author;
import com.example.publishinghouse.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/author")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public int addAuthor(@Validated @NonNull @RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "{idAuthor}")
    public Author getAuthorById(@PathVariable("idAuthor") int id) {
        return authorService.getAuthorById(id).orElse(null);
    }

    @PutMapping(path = "{idAuthor}/publishingHouse/{idPublishingHouse}")
    public Optional<Author> addAuthorToPublishingHouse(@PathVariable("idAuthor")int idA, @PathVariable("idPublishingHouse")int idPH) {
        return authorService.addAuthorToPublishingHouse(idA, idPH);
    }

    @GetMapping(path = "publishingHouse/{idPublishingHouse}")
    public List<Author> getAllAuthorsByPublishingH(@PathVariable("idPublishingHouse") int idPH) {
        return authorService.getAllAuthorsByPublishingHouse(idPH);
    }

    @DeleteMapping(path = "{idAuthor}")
    public void deleteAuthorById(@PathVariable("idAuthor") int id) {
        authorService.deleteAuthorById(id);
    }

    @PutMapping(path = "{idAuthor}")
    public void updateAuthorById(@PathVariable("idAuthor") int id, @Validated @NonNull @RequestBody int bookVersionToUpdate) {
        authorService.updateAuthorById(id, bookVersionToUpdate);
    }
}
