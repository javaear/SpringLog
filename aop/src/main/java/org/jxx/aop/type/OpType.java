package org.jxx.aop.type;

/**
 * @Description: start end around 根据习惯定义
 * @Author: javaear
 * @Version: 1.0
 */
public enum OpType {
    /**
     * prefix
     */
    START("start"),
    /**
     * Suffix
     */
    END("end"),
    /**
     * 方法开始结束都记录
     */
    AROUND("around");

    private final String value;

    private OpType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
