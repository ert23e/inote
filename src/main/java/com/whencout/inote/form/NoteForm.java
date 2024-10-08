package com.whencout.inote.form;


public class NoteForm {

    long noteId;
    String title;
    String contents;
    String tags;
    public long getNoteId() {
        return noteId;
    }
    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    
}
