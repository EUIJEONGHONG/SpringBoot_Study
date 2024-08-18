/*폼데이터를 받아올 그릇
 앞서 제목, 내용 두개의 데이털르 받기때문에 필드 두개 생성
 */
package com.example.CojadanProject.dto;

import com.example.CojadanProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
/*
//    생성자
    public ArticleForm(String title, String content){
        this.title = title;
        this.content = content;
    }
//    데이터 수신 확인용 문자열 변환 메서드 추가

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
 */

    public Article toEntity(){
        return new Article(id,title,content);
    }
}
