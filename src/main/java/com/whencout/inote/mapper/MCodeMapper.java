package com.whencout.inote.mapper;

import com.whencout.inote.entity.MCode;
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
public interface MCodeMapper {
    @Delete({
        "delete from m_code",
        "where code = #{code,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String code);

    @Insert({
        "insert into m_code (code, name)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(MCode row);

    @Select({
        "select",
        "code, name",
        "from m_code",
        "where code = #{code,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    MCode selectByPrimaryKey(String code);

    @Select({
        "select",
        "code, name",
        "from m_code order by code"
    })
    @Results({
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<MCode> selectAll();

    @Update({
        "update m_code",
        "set name = #{name,jdbcType=VARCHAR}",
        "where code = #{code,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MCode row);
}