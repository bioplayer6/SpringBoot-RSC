package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Note;
import project.repository.NoteJpa;

@Service
public class NoteService {

	@Resource
	private NoteJpa noteJpa;
	
	public Note saveNote(Note note) {
		return noteJpa.save(note);
	}
	
	public List<Note> findNotes(){
		return noteJpa.getAllNotes();
	}
	
	public Note findNoteById(Integer nid) {
		return noteJpa.getNoteById(nid);
	}
}
