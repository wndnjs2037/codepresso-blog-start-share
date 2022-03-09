package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostPageController {
    private PostService postService; //PostService 객체 생성

    //의존성 주입 코드 작성
    public PostPageController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/post/{id}") //url 지정
    public String getPostDetailPage(Model model, @PathVariable Integer id){ //상세보기 화면에 view를 서빙하기 위한 메소드
        Post post = postService.getPostById(id); //PostService의 PostById 메소드 호출
        model.addAttribute("post", post); //post 객체로 반환된 위의 데이터를 model에 추가해줌
        return "post_detail"; //최종적으로 post Deatil 뷰를 서빙해주도록 리턴 설정
    }

}
