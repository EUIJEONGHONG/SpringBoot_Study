package com.example.CojadanProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
public class Article {
    @Id //엔티티의 대푯값으로 제목과 내용이 같은 엔티티가 잇더라도 Id로 다른 테이블(엔티티)인 걸 구분해줌
    @GeneratedValue //자동생성기능 (숫자가 자동으로 생성되는 기능)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
/*
    //생성자로 현재 롬복에 의해 대체됨
    public Article(Long id, String title, String content){
        this.id =id;
        this.title = title;
        this.content = content;

    }
    //작동 확인을 위한 출력용 문자열로 현재 롬복에 의해 대체됨
    @Override
    public String toString(){
        return "Article{"
                + "id=" + id +'\''
                + "title=" + title +'\''
                + "content=" + content + '\''+"}";
    }
 */

}
