package com.codepresso.codepressoblog.controller;


import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    //블로그 글 데이터를 가져오기 위해 PostSevice 객체를 생성해서 의존성을 주입해준다.
    private PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Post> postList = postService.getPostByPage(1, 3); //처음 조회될 페이지 오프셋와 개수 입력
        model.addAttribute("posts", postList);
        return "index";
    }
}
