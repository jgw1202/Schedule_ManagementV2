package com.example.schedule_managementv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scheduler")
@NoArgsConstructor
@Getter
public class Scheduler extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Scheduler(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

}
