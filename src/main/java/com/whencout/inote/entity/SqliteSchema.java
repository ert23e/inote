package com.whencout.inote.entity;

import java.io.Serializable;

public class SqliteSchema implements Serializable {
    private String type;

    private String name;

    private String tblName;

    private Integer rootpage;

    private String sql;

    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public SqliteSchema withType(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public SqliteSchema withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTblName() {
        return tblName;
    }

    public SqliteSchema withTblName(String tblName) {
        this.setTblName(tblName);
        return this;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName == null ? null : tblName.trim();
    }

    public Integer getRootpage() {
        return rootpage;
    }

    public SqliteSchema withRootpage(Integer rootpage) {
        this.setRootpage(rootpage);
        return this;
    }

    public void setRootpage(Integer rootpage) {
        this.rootpage = rootpage;
    }

    public String getSql() {
        return sql;
    }

    public SqliteSchema withSql(String sql) {
        this.setSql(sql);
        return this;
    }

    public void setSql(String sql) {
        this.sql = sql == null ? null : sql.trim();
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
        SqliteSchema other = (SqliteSchema) that;
        return (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTblName() == null ? other.getTblName() == null : this.getTblName().equals(other.getTblName()))
            && (this.getRootpage() == null ? other.getRootpage() == null : this.getRootpage().equals(other.getRootpage()))
            && (this.getSql() == null ? other.getSql() == null : this.getSql().equals(other.getSql()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTblName() == null) ? 0 : getTblName().hashCode());
        result = prime * result + ((getRootpage() == null) ? 0 : getRootpage().hashCode());
        result = prime * result + ((getSql() == null) ? 0 : getSql().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", tblName=").append(tblName);
        sb.append(", rootpage=").append(rootpage);
        sb.append(", sql=").append(sql);
        sb.append("]");
        return sb.toString();
    }
}