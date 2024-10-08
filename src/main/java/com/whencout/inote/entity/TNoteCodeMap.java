package com.whencout.inote.entity;

import java.io.Serializable;

public class TNoteCodeMap implements Serializable {
    private Integer noteId;

    private String code;

    private static final long serialVersionUID = 1L;

    public Integer getNoteId() {
        return noteId;
    }

    public TNoteCodeMap withNoteId(Integer noteId) {
        this.setNoteId(noteId);
        return this;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getCode() {
        return code;
    }

    public TNoteCodeMap withCode(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TNoteCodeMap other = (TNoteCodeMap) that;
        return (this.getNoteId() == null ? other.getNoteId() == null : this.getNoteId().equals(other.getNoteId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoteId() == null) ? 0 : getNoteId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noteId=").append(noteId);
        sb.append(", code=").append(code);
        sb.append("]");
        return sb.toString();
    }
}