package com.example.publishinghouse.api;

import com.example.publishinghouse.model.PublishingHouse;
import com.example.publishinghouse.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/publishingH")
@RestController
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @PostMapping()
    public int addPublishingHouse(@Validated @NonNull @RequestBody PublishingHouse publishingHouse) {
        return publishingHouseService.addPublishingHouse(publishingHouse);
    }

    @GetMapping
    public List<PublishingHouse> getAllPublishingHouses() {
        return publishingHouseService.getAllPublishingHouses();
    }

    @GetMapping(path = "{idPublishingHouse}")
    public PublishingHouse getPublishingHouseById(@PathVariable("idPublishingHouse") int id) {
        return publishingHouseService.getPublishingHouseById(id).orElse(null);
    }

    @DeleteMapping(path = "{idPublishingHouse}")
    public void deletePublishingHouseById(@PathVariable("idPublishingHouse") int id) {
        publishingHouseService.deletePublishingHouseById(id);
    }

    @PutMapping(path = "{idPublishingHouse}")
    public void updatePublishingHouseById(@PathVariable("idPublishingHouse") int id, @Validated @NonNull @RequestBody String locationToUpdate) {
        publishingHouseService.updatePublishingHouseById(id, locationToUpdate);
    }
}
