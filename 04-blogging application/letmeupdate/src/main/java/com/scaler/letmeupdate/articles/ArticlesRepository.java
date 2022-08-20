package com.scaler.letmeupdate.articles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<ArticleEntity, Integer> {
}