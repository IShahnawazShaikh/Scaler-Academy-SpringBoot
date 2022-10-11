package com.scaler.moviecatalogservice.controller;

import com.scaler.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        return Arrays.asList(
                new CatalogItem("Don","description-01",9),
                new CatalogItem("Bahubali","description-02",10)
                );
    }
}
