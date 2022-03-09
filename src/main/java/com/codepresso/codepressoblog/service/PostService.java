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

    //findOne 메소드를 호출할 수 있는 코드 만들어주기
    public Post getPostById(Integer id){ //id를 파라미터로 보내서 id 정보를 postMapper의 findOne 호출에 사용
        return postMapper.findOne(id);
    }

    //savePost 메소드 추가하기
    public boolean savePost(Post post) { //Post객체를 인자로 받아서 불리언으로 리턴
        Integer result = postMapper.save(post);
        return result == 1; //처리가 성공하면 1이 나옴, 성공한다면 리턴해줌
    }

}