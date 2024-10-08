package com.whencout.inote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.whencout.inote.entity.TNote;
import com.whencout.inote.entity.TNoteCodeMap;
import com.whencout.inote.form.NoteForm;
import com.whencout.inote.mapper.TNoteCodeMapMapper;
import com.whencout.inote.mapper.TNoteMapper;

@Service
public class NoteService extends BaseService {


    @Autowired
    TNoteMapper tNoteMapper;
    
    @Autowired
    TNoteCodeMapMapper tNoteCodeMapMapper;
    
    public void saveNote(NoteForm noteForm) {
        
        tNoteMapper.updateBanchByPrimaryKey(noteForm.getNoteId());
        
        TNote note = new TNote();
        note.setNoteId( (int) noteForm.getNoteId());
        note.setTitle(noteForm.getTitle());
        note.setContents(noteForm.getContents());
        note.setNoteBanch(0);
        note.setCreatedAt(nowStr());
        
        tNoteMapper.insert(note);
        
        tNoteCodeMapMapper.deleteByNoteId((int)noteForm.getNoteId());
        
        if(StringUtils.hasLength(noteForm.getTags())) {
            String[] codes = noteForm.getTags().split(",");
            
            for (int i = 0; i < codes.length; i++) {
                TNoteCodeMap mp = new TNoteCodeMap();
                mp.setNoteId((int)noteForm.getNoteId());
                mp.setCode(codes[i]);
                tNoteCodeMapMapper.insert(mp);
            }
        }
        
        
        
    }

    public void deleteNote(Long noteId) {
        
        tNoteMapper.deleteByNoteId(noteId.intValue() , nowStr());
        
    }

    public void revivalNote(Long noteId) {
        tNoteMapper.revivalByNoteId(noteId.intValue());
        
    }
}
