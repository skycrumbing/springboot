package com.how2java.springboot.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
@Entity
public class User implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private String content;

        private Integer weight;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

}
