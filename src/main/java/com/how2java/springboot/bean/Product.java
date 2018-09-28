package com.how2java.springboot.bean;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
//为类提供读写属性
@Data
//提供无参构造方法
@NoArgsConstructor
@Entity
@Table(name = "category_")
public class Product {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

}
