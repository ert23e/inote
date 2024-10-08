package com.whencout.inote.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whencout.inote.entity.MCode;
import com.whencout.inote.mapper.MCodeMapper;

@Controller
@RequestMapping("/code")
public class CodeControl {
    
    @Autowired
    MCodeMapper mCodeMapper;
    
    @Transactional
    @GetMapping("/list")
    public String index(Model model) {
        List<MCode> mcodeList = mCodeMapper.selectAll();
        
        model.addAttribute("mcodeList", mcodeList);
        return "code/list";
    }
}
