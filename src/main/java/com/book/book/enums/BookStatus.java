package com.book.book.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BookStatus {
    FREE("Свободен"),
    BUSY("Занято")

    ;

    String desc;
}
