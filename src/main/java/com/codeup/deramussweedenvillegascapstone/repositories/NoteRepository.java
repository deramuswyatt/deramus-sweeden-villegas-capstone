package com.codeup.deramussweedenvillegascapstone.repositories;

import com.codeup.deramussweedenvillegascapstone.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findNotesById(long id);

    Note searchAllByTitleOrBodyOrPropertyZipContaining(String query);
}
