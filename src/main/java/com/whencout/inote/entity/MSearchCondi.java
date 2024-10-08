package com.whencout.inote.entity;

import java.io.Serializable;

public class MSearchCondi implements Serializable {
    private Integer id;

    private String title;

    private String condi;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public MSearchCondi withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public MSearchCondi withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCondi() {
        return condi;
    }

    public MSearchCondi withCondi(String condi) {
        this.setCondi(condi);
        return this;
    }

    public void setCondi(String condi) {
        this.condi = condi == null ? null : condi.trim();
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
        MSearchCondi other = (MSearchCondi) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCondi() == null ? other.getCondi() == null : this.getCondi().equals(other.getCondi()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCondi() == null) ? 0 : getCondi().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", condi=").append(condi);
        sb.append("]");
        return sb.toString();
    }
}