package com.example.exercise_14tuwaiqjavabootcamp.Controller;

import com.example.exercise_14tuwaiqjavabootcamp.ApiResponse.ApiResponse;
import com.example.exercise_14tuwaiqjavabootcamp.Model.NewsArticle;
import com.example.exercise_14tuwaiqjavabootcamp.Service.NewsAtricleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsArticleController {

    //Endpoints:
    //1. Get all NewsArticles.
    //2. Add a NewsArticle.
    //3. Update a NewsArticle.
    //4. Delete a NewsArticle.
    //5. Publish NewsArticles.
    //6. Get all Published NewsArticles.
    //7. Get NewsArticles by Category.
    private final NewsAtricleService newsAtricleService;

    @GetMapping("/get")
    public ResponseEntity getAllNews() {
        if (newsAtricleService.getAllNews().isEmpty())
            return ResponseEntity.status(200).body(new ApiResponse("no News found!!"));
        return ResponseEntity.status(200).body(newsAtricleService.getAllNews());
    }

    @PostMapping("/add")
    public ResponseEntity addNews(@RequestBody @Valid NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (newsAtricleService.addNews(newsArticle))
            return ResponseEntity.status(200).body(new ApiResponse("News Article added"));
        return ResponseEntity.status(400).body(new ApiResponse("News Article already exist in system"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateNews(@PathVariable String id,@RequestBody@Valid NewsArticle newsArticle,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (newsAtricleService.updateNews(id,newsArticle)){
            return ResponseEntity.status(200).body(new ApiResponse(newsArticle.getTitle()+" is updated!!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("this article not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNews(@PathVariable String id){
        if (newsAtricleService.deleteNews(id))
            return ResponseEntity.status(200).body(new ApiResponse("news with ID: "+id+", is deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("cannot delete. not exist"));
    }




}
