package com.scaler.letmeupdate.articles;

import com.scaler.letmeupdate.common.BaseEntity;
import com.scaler.letmeupdate.users.UserEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="articles")
public class ArticleEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false)
    private String heading;

    @NonNull
    @Column(nullable = false)
    private String subHeading;

    @NonNull
    @Column(nullable = false)
    private String slug;

    @NonNull
    @Column(nullable = false)
    private String content;

    //	private List<String> tags;

    @ManyToOne
    @JoinColumn(name="author_id")
    private UserEntity userEntity;
}
