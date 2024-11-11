package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
    private int storeno;
    private String title;
    private String cont;
    private String addr;
    private String tel;
}
