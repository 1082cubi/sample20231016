package com.example.sample1.controller;

import com.example.sample1.dao.TodoDao;
import com.example.sample1.domain.Todo;
//import com.example.sample1.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private TodoDao todoDao;

    @GetMapping("/")
    public String home(Model model) throws Exception {
        // 할 일 리스트 읽고 모델에 넣기
        List<Todo> list = todoDao.list();
        model.addAttribute("todoList", list);


        return "home";
    }

    @PostMapping("/add")
    public String add (Todo todo,

                       RedirectAttributes rttr) throws SQLException, IOException {
        // 새 할 일 추가 하고
        boolean result = todoDao.insert(todo);
        // 결과 model에 넣고

        // home으로 redirect
        return "redirect:/";
    }
}