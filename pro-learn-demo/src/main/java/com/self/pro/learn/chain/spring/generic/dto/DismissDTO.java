package com.self.pro.learn.chain.spring.generic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DismissDTO {

    private Long userId;

    private Long groupId;
}

