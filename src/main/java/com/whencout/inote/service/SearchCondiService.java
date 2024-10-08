package com.whencout.inote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whencout.inote.entity.MSearchCondi;
import com.whencout.inote.mapper.MSearchCondiMapper;

@Service
public class SearchCondiService  extends BaseService {

    @Autowired
    private MSearchCondiMapper mSearchCondiMapper;

    public MSearchCondi getSearchCondiById(Integer id) {
        return mSearchCondiMapper.selectByPrimaryKey(id);
    }

    public void updateSearchCondi(MSearchCondi searchCondi) {
        mSearchCondiMapper.updateByPrimaryKey(searchCondi);
    }
}
