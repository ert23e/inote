package com.whencout.inote.entity;

import java.io.Serializable;

public class VNoteList implements Serializable {
    private Integer noteId;

    private String title;

    private Integer noteBanch;

    private String contents;

    private String createdAt;

    private String deletedAt;

    private String tags;

    private static final long serialVersionUID = 1L;

    public Integer getNoteId() {
        return noteId;
    }

    public VNoteList withNoteId(Integer noteId) {
        this.setNoteId(noteId);
        return this;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public VNoteList withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getNoteBanch() {
        return noteBanch;
    }

    public VNoteList withNoteBanch(Integer noteBanch) {
        this.setNoteBanch(noteBanch);
        return this;
    }

    public void setNoteBanch(Integer noteBanch) {
        this.noteBanch = noteBanch;
    }

    public String getContents() {
        return contents;
    }

    public VNoteList withContents(String contents) {
        this.setContents(contents);
        return this;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public VNoteList withCreatedAt(String createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt == null ? null : createdAt.trim();
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public VNoteList withDeletedAt(String deletedAt) {
        this.setDeletedAt(deletedAt);
        return this;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt == null ? null : deletedAt.trim();
    }

    public String getTags() {
        return tags;
    }

    public VNoteList withTags(String tags) {
        this.setTags(tags);
        return this;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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
        VNoteList other = (VNoteList) that;
        return (this.getNoteId() == null ? other.getNoteId() == null : this.getNoteId().equals(other.getNoteId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getNoteBanch() == null ? other.getNoteBanch() == null : this.getNoteBanch().equals(other.getNoteBanch()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoteId() == null) ? 0 : getNoteId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getNoteBanch() == null) ? 0 : getNoteBanch().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noteId=").append(noteId);
        sb.append(", title=").append(title);
        sb.append(", noteBanch=").append(noteBanch);
        sb.append(", contents=").append(contents);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", tags=").append(tags);
        sb.append("]");
        return sb.toString();
    }
}