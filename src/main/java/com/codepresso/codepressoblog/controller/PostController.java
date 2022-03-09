package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.controller.dto.PostRequestDto;
import com.codepresso.codepressoblog.controller.dto.PostResponseDto;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private PostService postService;

    //의존성 주입 관련 코드 생성
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post") //PostResponseDto가 저장된 List 객체를 반환하는 메소드
    public List<PostResponseDto> getPostList(@RequestParam Integer page) {
        List<Post> postList = postService.getPostByPage(page,3); //page와 size 정보를 넘겨서 그걸 기반으로 PostList 객체 반환

        //최종적으로 메소드에서 응답할 PostResponseDto 객체가 저장되어 있는 어레이 생성
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for(Post post : postList) { //getPostByPage에서 조회해온 PostList를 반복하면서 Post객체를 하나씩 꺼내와서
            postResponseDtoList.add(new PostResponseDto(post)); //그 객체를 사용해서 PostResponseDto를 만든다.
        }

        return postResponseDtoList; //최종적으로는 add가 완료된 Dto 객체를 반환한다.
    }

    @PostMapping("/post")
    public String createPost(@RequestBody PostRequestDto postDto) { //이전에 만들어놓은 Dto로 데이터를 받는다.
        Post post = postDto.getPost(); //PostRequestDto에 저장되어있는 getPost 메소드를 통해 Post 객체를 생성
        postService.savePost(post); //위에서 만든 Post객체를 인자로 넣어서 savePost 메소드 실행

        return "success"; //성공한다면 성공했다는 텍스트 리턴
    }

}
