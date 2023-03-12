package com.codeup.deramussweedenvillegascapstone.repositories;

import com.codeup.deramussweedenvillegascapstone.models.Note;
import com.codeup.deramussweedenvillegascapstone.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findById(long id);

//    Property findByUser_Id(long id);
//
//    Property findAllByUser_Id(long id);
//
//    Property findPropertiesByUser_Id(long id);
//
//    Property findPropertyByUser(long id);
//
//    @Query("from Property a where a.user = :id ")
//    List<Property> searchByPropertyLike(@Param("id") long id);


}
