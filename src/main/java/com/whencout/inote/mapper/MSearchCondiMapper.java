package com.whencout.inote.mapper;

import com.whencout.inote.entity.MSearchCondi;
import com.whencout.inote.entity.TNote;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface MSearchCondiMapper {
    @Delete({
        "delete from m_search_condi",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into m_search_condi (id, title, ",
        "condi)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{condi,jdbcType=VARCHAR})"
    })
    int insert(MSearchCondi row);

    @Select({
        "select",
        "id, title, condi",
        "from m_search_condi",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="condi", property="condi", jdbcType=JdbcType.VARCHAR)
    })
    MSearchCondi selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, title, condi",
        "from m_search_condi"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="condi", property="condi", jdbcType=JdbcType.VARCHAR)
    })
    List<MSearchCondi> selectAll();

    @Select({
        "select",
        "max(id) id",
        "from m_search_condi"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    MSearchCondi selectMaxId();
    
    
    @Update({
        "update m_search_condi",
        "set title = #{title,jdbcType=VARCHAR},",
          "condi = #{condi,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MSearchCondi row);
}