package com.codeup.deramussweedenvillegascapstone.repositories;

import com.codeup.deramussweedenvillegascapstone.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findNotesById(long id);

    Note searchNotesByTitleOrBodyOrCategoryLike(String title, String body, String category);

    @Query("from Note a where a.title LIKE  %:term% OR a.body LIKE  %:term% OR a.category like %:term%")
    List<Note> searchByNoteLike(@Param("term") String term);


}
