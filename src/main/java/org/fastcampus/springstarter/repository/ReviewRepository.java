package org.fastcampus.springstarter.repository;

import org.fastcampus.springstarter.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // JPQL
   /* @Query("SELECT AVG(r.rating) FROM Review r WHERE r.book.id = :book_id")
    public Double findAverageRatingByBookId(@Param("book_id") Long book_id);*/
    @Query(value = "SELECT AVG(r.rating) FROM review r WHERE r.book_id = :book_id", nativeQuery = true)
    public Double findAverageRatingByBookId(@Param("book_id") Long book_id);


}
