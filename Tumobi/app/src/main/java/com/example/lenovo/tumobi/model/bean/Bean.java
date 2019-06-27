package com.example.lenovo.tumobi.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by 吕尚勇 on 2019/6/24.
 */

@Entity
public class Bean {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private String name;

    @Generated(hash = 417670818)
    public Bean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 80546095)
    public Bean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
