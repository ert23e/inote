package com.whencout.inote.mapper;

import com.whencout.inote.entity.TNote;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TNoteMapper {
    @Delete({
        "delete from t_note",
        "where note_id = #{noteId,jdbcType=INTEGER}",
          "and note_banch = #{noteBanch,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("noteId") Integer noteId, @Param("noteBanch") Integer noteBanch);

    @Update({
        "update t_note",
        "set deleted_at = #{deletedAt,jdbcType=VARCHAR}",
        "where note_id = #{noteId,jdbcType=INTEGER}"
    })
    int deleteByNoteId(@Param("noteId") Integer noteId, @Param("deletedAt") String deletedAt);
    
    @Update({
        "update t_note",
        "set deleted_at = ''",
        "where note_id = #{noteId,jdbcType=INTEGER}"
    })
    int revivalByNoteId(@Param("noteId") Integer noteId);

    @Insert({
        "insert into t_note (note_id, note_banch, ",
        "title, contents, ",
        "created_at, deleted_at)",
        "values (#{noteId,jdbcType=INTEGER}, #{noteBanch,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{contents,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=VARCHAR}, #{deletedAt,jdbcType=VARCHAR})"
    })
    int insert(TNote row);

    @Select({
        "select",
        "note_id, note_banch, title, contents, created_at, deleted_at",
        "from t_note",
        "where note_id = #{noteId,jdbcType=INTEGER}",
          "and note_banch = #{noteBanch,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="note_banch", property="noteBanch", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.VARCHAR)
    })
    TNote selectByPrimaryKey(@Param("noteId") Integer noteId, @Param("noteBanch") Integer noteBanch);

    @Select({
        "select",
        "note_id, note_banch, title, contents, created_at, deleted_at",
        "from t_note"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="note_banch", property="noteBanch", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.VARCHAR)
    })
    List<TNote> selectAll();
    
    @Select({
        "select",
        "max(note_id) note_id",
        "from t_note"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER, id=true)
    })
    TNote selectMaxNoteId();

    @Update({
        "update t_note",
        "set title = #{title,jdbcType=VARCHAR},",
          "contents = #{contents,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=VARCHAR},",
          "deleted_at = #{deletedAt,jdbcType=VARCHAR}",
        "where note_id = #{noteId,jdbcType=INTEGER}",
          "and note_banch = #{noteBanch,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TNote row);
    
    @Update({
        "update t_note",
        "set note_banch = note_banch - 1",
        "where note_id = #{noteId}"
    })
    int updateBanchByPrimaryKey(@Param("noteId") Long noteId);
}