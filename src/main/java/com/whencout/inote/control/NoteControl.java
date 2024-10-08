package com.whencout.inote.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whencout.inote.entity.MCode;
import com.whencout.inote.entity.MSearchCondi;
import com.whencout.inote.entity.TNote;
import com.whencout.inote.entity.VNoteList;
import com.whencout.inote.form.NoteForm;
import com.whencout.inote.mapper.MCodeMapper;
import com.whencout.inote.mapper.MSearchCondiMapper;
import com.whencout.inote.mapper.TNoteMapper;
import com.whencout.inote.mapper.VNoteListMapper;
import com.whencout.inote.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteControl {

    @Autowired
    VNoteListMapper vNoteListMapper;
    
    @Autowired
    MCodeMapper mCodeMapper;
    
    @Autowired
    TNoteMapper tNoteMapper;
    
    @Autowired
    private MSearchCondiMapper mSearchCondiMapper;
    
    @Autowired
    NoteService noteService;
    
    @GetMapping("/list")
    public String index(Model model) {
        List<VNoteList> tnoteList =  vNoteListMapper.selectAllNotDelete();
        List<MSearchCondi> scList = mSearchCondiMapper.selectAll();
        
        for (VNoteList vNoteList : tnoteList) {
            vNoteList.setContents(vNoteList.getContents().replaceAll("\n", "<br>"));
        }
        
        model.addAttribute("tnoteList", tnoteList);
        model.addAttribute("showDel", "0");
        model.addAttribute("scList", scList);
        model.addAttribute("searchId", "1");
        return "note/list";
    }
    
    @GetMapping("/list2")
    public String index2(@RequestParam("showDel") String showDel, Model model) {
        List<VNoteList> tnoteList =  new ArrayList<>();
        List<MSearchCondi> scList = mSearchCondiMapper.selectAll();
        if("1".equals(showDel)) {
            tnoteList =  vNoteListMapper.selectAll();
        }else {
            tnoteList =  vNoteListMapper.selectAllNotDelete();
        }
        
        for (VNoteList vNoteList : tnoteList) {
            vNoteList.setContents(vNoteList.getContents().replaceAll("\n", "<br>"));
        }
        
        model.addAttribute("tnoteList", tnoteList);
        model.addAttribute("showDel", showDel);
        model.addAttribute("scList", scList);
        return "note/list";
    }

    // 編集画面表示
    @GetMapping("/search/{searchId}")
    public String search(@PathVariable("searchId") Integer searchId, Model model) {
        MSearchCondi searchCondi = mSearchCondiMapper.selectByPrimaryKey(searchId);

        List<VNoteList> tnoteList =  new ArrayList<>();
        
        if(searchCondi == null) {
            tnoteList =  vNoteListMapper.selectAllNotDelete();
        }else {
            tnoteList =  vNoteListMapper.selectAllWithCondi(searchCondi.getCondi());
        }
        List<MSearchCondi> scList = mSearchCondiMapper.selectAll();
        
        for (VNoteList vNoteList : tnoteList) {
            vNoteList.setContents(vNoteList.getContents().replaceAll("\n", "<br>"));
        }
        
        model.addAttribute("tnoteList", tnoteList);
        model.addAttribute("showDel", "0");
        model.addAttribute("scList", scList);
        model.addAttribute("searchId", searchId);
        
        return "note/list";  // Thymeleafテンプレートのファイル名
    }
    
    
    @GetMapping("/edit")
    public String edit(@RequestParam("noteId") Long noteId, Model model) {
        // noteIdを使用して必要なデータを取得し、モデルに追加
        VNoteList note = vNoteListMapper.findNoteById(noteId, 0);
        // 利用可能なタグのリスト
        
        List<MCode> codeList = mCodeMapper.selectAll();
        
        model.addAttribute("note", note);
        model.addAttribute("codeList", codeList);
        
        return "note/edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("noteId") Long noteId, Model model) {

        // タグをカンマ区切りで保存するなどの処理を行う
        noteService.deleteNote(noteId);
        
        return index(model);
    }
    @GetMapping("/revival")
    public String revival(@RequestParam("noteId") Long noteId, Model model) {
        
        // タグをカンマ区切りで保存するなどの処理を行う
        noteService.revivalNote(noteId);
        
        return index(model);
    }
    
    @GetMapping("/new")
    public String regist(Model model) {
        // noteIdを使用して必要なデータを取得し、モデルに追加
        TNote noteOne = tNoteMapper.selectMaxNoteId();
        VNoteList note = new VNoteList();
        if(noteOne == null || noteOne.getNoteId() == null) {
            note.setNoteId(1);
        }else {
            note.setNoteId(noteOne.getNoteId() + 1);
        }
        note.setContents("");
        note.setCreatedAt("");
        note.setDeletedAt("");
        note.setNoteBanch(0);
        note.setTags("");
        note.setTitle("");
        
        List<MCode> codeList = mCodeMapper.selectAll();
        
        model.addAttribute("note", note);
        model.addAttribute("codeList", codeList);
        
        return "note/edit";
    }
    
    @PostMapping("/edit")
    public String updateNote(
            @ModelAttribute NoteForm noteForm,
            Model model) {
            // タグをカンマ区切りで保存するなどの処理を行う
            noteService.saveNote(noteForm);

            return "redirect:/note/list";
        }
    
    
    
}
