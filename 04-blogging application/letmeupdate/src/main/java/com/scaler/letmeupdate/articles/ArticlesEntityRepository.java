package com.scaler.letmeupdate.articles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesEntityRepository extends JpaRepository<ArticleEntity, Integer> {
}