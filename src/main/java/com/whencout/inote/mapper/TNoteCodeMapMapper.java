package com.whencout.inote.mapper;

import com.whencout.inote.entity.TNoteCodeMap;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TNoteCodeMapMapper {
    @Delete({
        "delete from t_note_code_map",
        "where note_id = #{noteId,jdbcType=INTEGER}",
          "and code = #{code,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("noteId") Integer noteId, @Param("code") String code);
    
    @Delete({
        "delete from t_note_code_map",
        "where note_id = #{noteId,jdbcType=INTEGER}"
    })
    int deleteByNoteId(@Param("noteId") Integer noteId);

    @Insert({
        "insert into t_note_code_map (note_id, code)",
        "values (#{noteId,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR})"
    })
    int insert(TNoteCodeMap row);

    @Select({
        "select",
        "note_id, code",
        "from t_note_code_map"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<TNoteCodeMap> selectAll();
}