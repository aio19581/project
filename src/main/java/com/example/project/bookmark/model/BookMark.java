package com.example.project.bookmark.model;

import com.example.project.user.model.User;
import com.example.project.store.model.Store;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {
    @JoinColumn(name = "bmark_user_no")
    @ManyToOne
    private User user;

    @JoinColumn(name="bmark_store_no")
    @ManyToOne
    private Store store;
}
