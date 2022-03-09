package com.codepresso.codepressoblog.controller.dto;

import com.codepresso.codepressoblog.vo.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    Integer id;
    String title;
    String content;
    String username;

    //생성자를 이용해서 객체 초기화함
    public PostResponseDto(Post post) { //request와 반대로, Post 객체로부터 responseDto를 만든다.
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUsername();
    }

}
