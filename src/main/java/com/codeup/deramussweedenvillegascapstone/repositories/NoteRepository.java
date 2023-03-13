package com.codeup.deramussweedenvillegascapstone.repositories;

import com.codeup.deramussweedenvillegascapstone.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findNotesById(long id);

    Note findById(long id);

    //This one works!
//    @Query("from Note a where a.title LIKE  %:term% OR a.body LIKE  %:term% OR a.category like %:term%")
//    List<Note> searchByTitleLike(@Param("term") String term);

    @Query("from Note a where a.title LIKE  %:term% OR a.body LIKE  %:term% OR a.category like %:term% OR a.property.city LIKE %:term% OR a.property.state LIKE %:term% OR a.property.street_add LIKE %:term%")
    List<Note> searchByTitleLike(@Param("term") String term);

//    @Query("from Note a where a.title LIKE %:term%")
//    List<Note> searchByTitleLike(@Param("term") String term);

//    @Query
//    List<Note> searchAllByBodyOrTitleoOrCategory(String query);

//    @Query
//    Note searchNotesByTitle(String query);


//    @Query("from Ad a where a.title like %:term%")
//    List<Ad> searchByTitleLike(@Param("term") String term);



}
