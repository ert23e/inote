package com.whencout.inote.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseService {

    protected String nowStr() {

        // 現在時刻を取得
        LocalDateTime now = LocalDateTime.now();
        // フォーマット指定
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ssSSS");
        // フォーマットに従って現在時刻を文字列に変換
        String formattedDate = now.format(formatter);
        return formattedDate;
    }
}
