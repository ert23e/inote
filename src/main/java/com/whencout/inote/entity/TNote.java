package com.whencout.inote.entity;

import java.io.Serializable;

public class TNote implements Serializable {
    private Integer noteId;

    private Integer noteBanch;

    private String title;

    private String contents;

    private String createdAt;

    private String deletedAt;

    private static final long serialVersionUID = 1L;

    public Integer getNoteId() {
        return noteId;
    }

    public TNote withNoteId(Integer noteId) {
        this.setNoteId(noteId);
        return this;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getNoteBanch() {
        return noteBanch;
    }

    public TNote withNoteBanch(Integer noteBanch) {
        this.setNoteBanch(noteBanch);
        return this;
    }

    public void setNoteBanch(Integer noteBanch) {
        this.noteBanch = noteBanch;
    }

    public String getTitle() {
        return title;
    }

    public TNote withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContents() {
        return contents;
    }

    public TNote withContents(String contents) {
        this.setContents(contents);
        return this;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public TNote withCreatedAt(String createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt == null ? null : createdAt.trim();
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public TNote withDeletedAt(String deletedAt) {
        this.setDeletedAt(deletedAt);
        return this;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt == null ? null : deletedAt.trim();
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
        TNote other = (TNote) that;
        return (this.getNoteId() == null ? other.getNoteId() == null : this.getNoteId().equals(other.getNoteId()))
            && (this.getNoteBanch() == null ? other.getNoteBanch() == null : this.getNoteBanch().equals(other.getNoteBanch()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoteId() == null) ? 0 : getNoteId().hashCode());
        result = prime * result + ((getNoteBanch() == null) ? 0 : getNoteBanch().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noteId=").append(noteId);
        sb.append(", noteBanch=").append(noteBanch);
        sb.append(", title=").append(title);
        sb.append(", contents=").append(contents);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append("]");
        return sb.toString();
    }
}