package com.scaler.letmeupdate.comments;

import com.scaler.letmeupdate.articles.ArticleEntity;
import com.scaler.letmeupdate.common.BaseEntity;
import com.scaler.letmeupdate.users.UserEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor@RequiredArgsConstructor
@Builder
@Entity
@Table(name="comments")
public class CommentEntity extends BaseEntity {

    private String title;

    @NonNull
    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name="author_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="article_id")
    private ArticleEntity articleEntity;
}
