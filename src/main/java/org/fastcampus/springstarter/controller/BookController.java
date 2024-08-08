package org.fastcampus.springstarter.controller;

import org.fastcampus.springstarter.entity.Book;
import org.fastcampus.springstarter.entity.Review;
import org.fastcampus.springstarter.service.BookService;
import org.fastcampus.springstarter.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

     @Autowired
     private ReviewService reviewService;

    @GetMapping("/")
    public String home(Model model){
        List<Book> books=bookService.getAll();
        // books->번지(List<Book> books)
        model.addAttribute("books", books); //객체바인딩
        return "home"; // home.html
    }

    @GetMapping("/detail/{id}")
    public String getDetails(@PathVariable Long id, Model model){
              Optional<Book> bookOptional=bookService.getById(id);
              if(bookOptional.isPresent()){
                      Book book=bookOptional.get(); // 리뷰정보도 담아져있다.
                      model.addAttribute("book", book);

                   // 평균 평점을 계산하여 모델에 추가
                   double averageRating = book.getReviews().stream()
                          .mapToInt(Review::getRating)
                          .average()
                          .orElse(0.0);
                     String formattedAverageRating = String.format("%.1f", averageRating);
                     model.addAttribute("averageRating", formattedAverageRating);

                      return "detail"; // 상세보기 View(detail.html) : ${book}
              }else{
                   return "redirect:/";
              }
    }

    @PostMapping("/register")
    public String reviewRregister(@RequestParam("book_id") Long book_id, Review review){
              Book book =bookService.getById(book_id).orElseThrow(()->new IllegalArgumentException("Invalid book id:"+book_id));
              review.setBook(book);
              review.setCreatedAt(LocalDateTime.now());
              reviewService.save(review); // 등록성공
              return "redirect:/detail/"+book.getId();
    }
}
