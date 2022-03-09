package com.codepresso.codepressoblog.controller.dto;

import com.codepresso.codepressoblog.vo.Post;
import lombok.Setter;

@Setter //롬복 사용을 위한 어노테이션, 이걸 추가하면 코드 상에는 없지만 setter 메소드가 생성된다. (view-도구 창-구조에서 확인)
public class PostRequestDto {
    Integer id;
    String title;
    String content;
    String username;

    public Post getPost() { //PostRequestDto에 작성되어있는 멤버변수를 기반으로 Post 객체를 생성하는 메소드
        return new Post(this.id, this.title, this.content, this.username);
    }

}
