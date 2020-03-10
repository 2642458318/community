package com.www.community.controller;

import com.www.community.dao.mapper.temp.QuestionMapper;
import com.www.community.dao.mapper.temp.UserMapper;
import com.www.community.model.Question;
import com.www.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ) {

        model.addAttribute(title);
        model.addAttribute(description);
        model.addAttribute(tag);
        if (title==null || title ==""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (description==null || description ==""){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        if (tag==null || tag ==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        User user = null;
        int num=0;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null &&cookies.length!=0)
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    Question question = new Question();
                    question.setTitle(title);
                    question.setDescription(description);
                    question.setTag(tag);
                    question.setCreator(user.getId());
                    question.setGmtCreat(System.currentTimeMillis());
                    question.setGmtModified(question.getGmtCreat());
                    question.setCommentCount(num++);
                    question.setViewCount(num++);
                    question.setLikeCount(num++);
                    questionMapper.create(question);
                }
                if (user == null) {
                    model.addAttribute("error", "用户未登录");
                    return "publish";
                }
            }
        }
        return "redirect:/";
    }

    @GetMapping("/publish")
    public String publish() {
        return "publish";

    }
}
