package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.PostMapper;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostMapper postMapper;

    public PostService(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    public List<Post> getAllPost() {
        return postMapper.fineAll(); // postmapper의 메소드를 호출해서 sql mapper 가 실행되도록 호출함.
    }

    //findeByPage를 호출하도록 만듦
    public List<Post> getPostByPage(Integer page, Integer size) {
        return postMapper.findByPage(size, (page-1) * size); //page와 size 값을 limit과 offset 으로 바꿔주는 역할
        //page는 1부터 입력되므로 limit으로 사용하기 위해서 -1을 해줌
    }

}
