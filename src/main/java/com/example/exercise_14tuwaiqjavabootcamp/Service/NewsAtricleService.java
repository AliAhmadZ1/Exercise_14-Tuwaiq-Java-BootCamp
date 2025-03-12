package com.example.exercise_14tuwaiqjavabootcamp.Service;

import com.example.exercise_14tuwaiqjavabootcamp.Model.NewsArticle;
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


}
