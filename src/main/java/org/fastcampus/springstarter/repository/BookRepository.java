package org.fastcampus.springstarter.repository;

import org.fastcampus.springstarter.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // 1. 기본적으로 JpaRepository에서 제공해주는 메서드를 사용하는 방법
    // 2. 직접 메서드를 만들 수도 있다. ?
}
