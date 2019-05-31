package com.dbs6339.webservice.domain.posts;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
