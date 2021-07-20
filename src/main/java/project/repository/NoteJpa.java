package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Note;


public interface NoteJpa extends JpaRepository<Note,Long>  {

	@Query("select w from project.pojo.Note as w")
	public List<Note> getAllNotes();
	
	@Query("select w from project.pojo.Note as w where note_id=?1")
	public Note getNoteById(Integer nid);
	
}
