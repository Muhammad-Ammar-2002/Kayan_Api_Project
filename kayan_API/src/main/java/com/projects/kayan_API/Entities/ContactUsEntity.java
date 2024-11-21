package com.projects.kayan_API.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "contact_us")
public class ContactUsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message_type")
    private String messageType;
    @Column(name = "message_content")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

//    public ContactUsEntity(String messageType, String content, Long userId) {
//        this.content=content;
//        this.messageType=messageType;
//        this.userId.setId(userId);
//    }
}
