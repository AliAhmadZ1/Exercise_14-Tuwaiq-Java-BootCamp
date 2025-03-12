package com.example.exercise_14tuwaiqjavabootcamp.Service;

import com.example.exercise_14tuwaiqjavabootcamp.ApiResponse.ApiResponse;
import com.example.exercise_14tuwaiqjavabootcamp.Model.NewsArticle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsAtricleService {

    ArrayList<NewsArticle> newsArticles = new ArrayList<>();

    public ArrayList<NewsArticle> getAllNews(){
        return newsArticles;
    }

    public boolean addNews(NewsArticle newsArticle) {
        for (NewsArticle n : newsArticles) {
            if (n.getId().equals(newsArticle.getId())) {
                return false;
            }
        }
        newsArticles.add(newsArticle);
        return true;
    }

    public boolean updateNews(String id,NewsArticle newsArticle){
        for (NewsArticle n: newsArticles){
            if (n.getId().equals(id)){
                newsArticles.set(newsArticles.indexOf(n),newsArticle);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNews(String id){
        for (NewsArticle n:newsArticles){
            if (n.getId().equals(id)){
                newsArticles.remove(n);
                return true;
            }
        }
        return false;
    }

    public boolean publishNews(String id){
        for (int index = 0; index < newsArticles.size(); index++) {
            if (newsArticles.get(index).getId().equals(id)&&!newsArticles.get(index).isPublished()){
                newsArticles.get(index).setPublished(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<NewsArticle> getAllPublished(){
        ArrayList<NewsArticle> published= new ArrayList<>();
        for (NewsArticle n: newsArticles){
            if (n.isPublished())
                published.add(n);
        }
        return published;
    }

    public ArrayList<NewsArticle> getByCategory(String category){
        ArrayList<NewsArticle> articlesByCategory = new ArrayList<>();
        for (NewsArticle n: newsArticles){
            if (n.getCategory().equals(category)){
                articlesByCategory.add(n);
            }
        }
        return articlesByCategory;
    }
}
