package com.example.exercise_14tuwaiqjavabootcamp.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {

    @NotEmpty(message = "cannot be empty")
    private String id;
    @NotEmpty(message = "cannot be empty")
    @Size(min = 4, max = 100,message = "title should be up to 100 characters...")
    private String title;
    @NotEmpty(message = "cannot be empty")
    @Size(min = 4,max = 20,message = "author SHOULD be more than 4 characters to 20 characters.")
    private String author;
    @NotEmpty(message = "cannot empty")
    @Size(min = 200,message = "CONTENT should be at least 200 characters")
    private String content;
    @NotEmpty(message = "cannot be empty")
    @Pattern(regexp = "^(politics|sports|technology)$",message = "category should be politics, sports or technology")
    private String category;
    @NotEmpty(message = "cannot empty")
    private String imageUrl;
    @AssertFalse(message = "isPublished should be false")
    private boolean isPublished;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate publishDate;
    //NewsArticle Model has:
        //▪ id:
            //- Cannot be null.
        // ▪ title:
            //- Cannot be null.
            //- Maximum length of 100 characters.
        //▪ author:
            //- Cannot be null.
            //- Must be more than 4 characters.
            //- Maximum length of 20 characters.
        //▪ content:
            //- Cannot be null.
            //- Must be more than 200 characters.
        //▪ category:
            //- Cannot be null.
            //- Must be either "politics", " sports" or " technology" only.
        //▪ imageUrl:
            //- Cannot be null.
        //▪ isPublished
            //- Must be by default false.
        //▪ publishDate
}
