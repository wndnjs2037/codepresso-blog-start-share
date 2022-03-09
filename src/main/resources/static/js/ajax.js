$(function(){
    $("#more").click(function(){ //id가 more인 객체 클릭시
        //console.log("clicked!"); //more 버튼 클릭시 이벤트 확인
        var next_page = parseInt($(this).attr("current-page")) + 1; //커런트페이지의 정보를 가져와서 1을 더해 넥스트 페이지의 정보를 만드는 부분
        // this 키워드는 클릭한 부분 그 자체의 태그를 의미한다.
        // 여기서는 more 버튼을 의미한다고 보면 된다.

        $.ajax({ //ajax 호출하기
            method : "GET",
            url : "/post",
            data : {"page":next_page} //요청할 페이지의 값 보내줌
        })
        .done(function(response) { //ajax 호출이 완료되면 실행될 구문
            for(var post of response) { //json 어레이에서 객체를 하나씩 꺼내와서 view에 표시
                $('#more-posts').append("<div class=\"post-preview\">" + //id가 morepost인 영역에 append 해줌
                    "<a href=\""/post/" + post.id +\">" + // post와 id를 연결해서 url로 만들어서 링크 연결하기
                    "<h2 class=\"post-title\">" +
                    post.title +
                    "</h2>\n" +
                    "<h3 class=\"post-subtitle\">" +
                    post.content +
                    "</h3></a><p class=\"post-meta\">Posted by" +
                    post.username +
                    "</p></div><hr class=\"my-4\" />");
                }
            });
            $(this).attr("current-page", next_page);

    });

    $(".comment-edit").hide();

    $(".comment-edit-form-button").click(function(){
        $(this).closest(".comment_text").find(".comment-edit").show();
    });

    $(".comment-edit-cancel-button").click(function(){
        $(this).closest(".comment_text").find(".comment-edit").hide();
    });
});