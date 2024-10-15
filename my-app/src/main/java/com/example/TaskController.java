/*To-Do リストアプリケーションにおけるコントローラークラスであり、ユーザーのリクエストに対する処理を行う役割を果たしています。Spring Frameworkを使って、HTTPリクエストを処理し、ビューやデータベース操作を行う仕組みです。*/

package com.example.controller;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* Controllerアノテーション付きのクラス・・・Spring MVC のコントローラーであることを示します。ブラウザから送られるリクエストを受け取り、対応するレスポンスを生成します。*/
@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "home";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String taskName) {
        Task task = new Task();
        task.setName(taskName);
        task.setCompleted(false);
        taskRepository.save(task);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
