package com.bestcxx.stu.springmybatis.model;

/**
 * 测试表 实体
 * test.test_table_one
 * @author WuJieJecket
 *
 */
public class TestTableOne {
    private Integer id;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}