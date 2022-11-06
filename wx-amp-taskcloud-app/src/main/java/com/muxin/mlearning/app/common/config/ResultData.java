package com.muxin.mlearning.app.common.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultData<T> {
    private Code code;
    private T bo;
    private Object other;

    static class Code{

    }
}
