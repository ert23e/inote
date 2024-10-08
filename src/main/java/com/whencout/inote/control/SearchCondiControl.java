package com.whencout.inote.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whencout.inote.entity.MSearchCondi;
import com.whencout.inote.mapper.CustomSelectMapper;
import com.whencout.inote.mapper.MCodeMapper;
import com.whencout.inote.mapper.MSearchCondiMapper;
import com.whencout.inote.mapper.TNoteMapper;
import com.whencout.inote.service.NoteService;

@Controller
@RequestMapping("/searchcondi")
public class SearchCondiControl {

    @Autowired
    MSearchCondiMapper mSearchCondiMapper;
    
    @Autowired
    MCodeMapper mCodeMapper;
    
    @Autowired
    TNoteMapper tNoteMapper;
    
    @Autowired
    private CustomSelectMapper customSelectMapper;
    
    @Autowired
    NoteService noteService;
    
    @GetMapping("/list")
    public String index(Model model) {
        List<MSearchCondi> scList =  mSearchCondiMapper.selectAll();
        
        model.addAttribute("scList", scList);
        return "searchcondi/list";
    }

    // 編集画面表示
    @GetMapping("/new")
    public String regist(Model model) {
        MSearchCondi searchCondi = new MSearchCondi();
        
        MSearchCondi condi =  mSearchCondiMapper.selectMaxId();
        if(condi == null || condi.getId() == null) {
            searchCondi.setId(1);
        }else {
            searchCondi.setId(condi.getId() + 1);
        }
        
        model.addAttribute("searchCondi", searchCondi);
        return "searchcondi/edit";  // Thymeleafテンプレートのファイル名
    }
    // 編集画面表示
    @GetMapping("/edit/{id}")
    public String editSearchCondi(@PathVariable("id") Integer id, Model model) {
        MSearchCondi searchCondi = mSearchCondiMapper.selectByPrimaryKey(id);
        model.addAttribute("searchCondi", searchCondi);
        return "searchcondi/edit";  // Thymeleafテンプレートのファイル名
    }

    // 更新処理
    @PostMapping("/update")
    public String updateSearchCondi(@ModelAttribute("searchCondi") MSearchCondi searchCondi) {
        MSearchCondi old = mSearchCondiMapper.selectByPrimaryKey(searchCondi.getId());
        if(old == null) {
            mSearchCondiMapper.insert(searchCondi);
        }else {
            mSearchCondiMapper.updateByPrimaryKey(searchCondi);
        }
        return "redirect:/searchcondi/list";  // リストページにリダイレクト
    }
    
    
}
