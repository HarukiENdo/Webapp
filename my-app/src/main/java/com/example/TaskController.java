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

    @Autowired /*役割: SpringのDI（依存性注入）機能を使って、他のクラスやオブジェクトを自動的にインジェクト（注入）します。*/
    private TaskRepository taskRepository;

    @GetMapping("/") /*HTTPのGETリクエスト（ブラウザでページを読み込む操作）を処理します。URLパスが / に対応しており、TaskRepository を使ってデータベースから全タスクを取得し、Model に追加します。*/
    public String home(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "home";
    }

    @PostMapping("/add") /*HTTPのPOSTリクエストを処理します。タスク名をリクエストパラメーター taskName として受け取り、新しい Task オブジェクトを作成してデータベースに保存します。*/
    public String addTask(@RequestParam String taskName, @RequestParam String priority) {
        Task task = new Task();
        task.setName(taskName);
        task.setPriority(priority); // 優先度を設定
        task.setCompleted(false);
        taskRepository.save(task);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}") /*ここでは、特定のタスクを完了済みとしてマークします。URLに含まれる id（タスクのID）で該当するタスクを検索し、completed フィールドを true に設定してデータベースに保存します。*/
    public String completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}") /*こちらは、特定のタスクを削除するための処理です。URLに含まれる id に基づいて、該当するタスクを削除します。*/
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    
}
