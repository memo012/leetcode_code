package com.adminsys.多线程.中奖;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-03 04-25
 **/

public class Prize {
    /**
     *  id
     */
    private Long id;
    /**
     * 奖品名称
     */
    private String name;
    /**
     *  剩余奖品数
     */
    private Integer surplus;
    /**
     *  奖品总数
     */
    private Integer total;
    /**
     * 概率
     */
    private Double probability;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
