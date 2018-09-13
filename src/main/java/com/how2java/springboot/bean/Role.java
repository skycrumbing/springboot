package com.how2java.springboot.bean;

import com.how2java.springboot.annotation.Table;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    Integer id;

    String name;
    @Column(name = "desc_")
    String desc;
}
