package com.whencout.inote.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.whencout.inote.entity.VNoteList;

@Mapper
public interface VNoteListMapper {
    @Insert({
        "insert into v_note_list (note_id, title, ",
        "note_banch, contents, ",
        "created_at, deleted_at, ",
        "tags)",
        "values (#{noteId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{noteBanch,jdbcType=INTEGER}, #{contents,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=VARCHAR}, #{deletedAt,jdbcType=VARCHAR}, ",
        "#{tags,jdbcType=VARCHAR})"
    })
    int insert(VNoteList row);

    @Select({
        "select",
        "note_id, title, note_banch, contents, created_at, deleted_at, tags",
        "from v_note_list where note_banch=0"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note_banch", property="noteBanch", jdbcType=JdbcType.INTEGER),
        @Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR)
    })
    List<VNoteList> selectAll();
    
    @Select({
        "select",
        "note_id, title, note_banch, contents, created_at, deleted_at, tags",
        "from v_note_list where note_banch=0 and (deleted_at is null or deleted_at = '')"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note_banch", property="noteBanch", jdbcType=JdbcType.INTEGER),
        @Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR)
    })
    List<VNoteList> selectAllNotDelete();
    
    @Select({
        "<script>",
        "select",
        "note_id, title, note_banch, contents, created_at, deleted_at, tags",
        "from v_note_list",
        "where note_banch = 0",
        "and (deleted_at is null or deleted_at = '')",
        "<if test='searchCondi != null and searchCondi != \"\"'>",
        "  and ${searchCondi}",
        "</if>",
        "</script>"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note_banch", property="noteBanch", jdbcType=JdbcType.INTEGER),
        @Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR)
    })
    List<VNoteList> selectAllWithCondi(@Param("searchCondi") String searchCondi );
    
    @Select({
        "select",
        "note_id, title, note_banch, contents, created_at, deleted_at, tags",
        "from v_note_list where note_id=#{noteId} and note_banch=#{noteBanch}"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note_banch", property="noteBanch", jdbcType=JdbcType.INTEGER),
        @Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR)
    })
    VNoteList findNoteById(@Param("noteId") Long noteId, @Param("noteBanch") Integer noteBanch);
}