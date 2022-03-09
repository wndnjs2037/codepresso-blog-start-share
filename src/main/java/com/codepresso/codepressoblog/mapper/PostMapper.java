package com.codepresso.codepressoblog.mapper;

import com.codepresso.codepressoblog.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> fineAll(); //post 타입으로 반환함
    List<Post> findByPage(@Param("limit") Integer limit, @Param("offset") Integer offset); //파라미터로 limit과 offset 추가 (페이지 더보기 기능)


}
