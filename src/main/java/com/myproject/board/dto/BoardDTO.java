package com.myproject.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

    private Long id;
    private String boardTitle;
    private String boardContent;

}
