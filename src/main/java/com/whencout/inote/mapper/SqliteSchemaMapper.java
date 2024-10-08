package com.whencout.inote.mapper;

import com.whencout.inote.entity.SqliteSchema;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SqliteSchemaMapper {
    @Insert({
        "insert into sqlite_schema (type, name, ",
        "tbl_name, rootpage, ",
        "sql)",
        "values (#{type,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{tblName,jdbcType=VARCHAR}, #{rootpage,jdbcType=INTEGER}, ",
        "#{sql,jdbcType=VARCHAR})"
    })
    int insert(SqliteSchema row);

    @Select({
        "select",
        "type, name, tbl_name, rootpage, sql",
        "from sqlite_schema"
    })
    @Results({
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="tbl_name", property="tblName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rootpage", property="rootpage", jdbcType=JdbcType.INTEGER),
        @Result(column="sql", property="sql", jdbcType=JdbcType.VARCHAR)
    })
    List<SqliteSchema> selectAll();
}