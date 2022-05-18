package com.boots.repository;

import com.boots.entity.Links;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends MongoRepository<Links,Long> {

    /**
     *Saving a file and entering data about it in DB
     * @param //links
     * @return Links
     */
    Links save(Links links);

}
