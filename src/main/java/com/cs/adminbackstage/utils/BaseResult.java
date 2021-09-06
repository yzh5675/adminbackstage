package com.cs.adminbackstage.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseResult<T> {

    private Integer code;

    private String msg;

    private String link;

    private List<T> obj;
}
