package com.selind.issuemanagementsystem.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data //Data bir interfacedir. Beş tane fields var. Bunların getter ve setter metotlarını lombok eklentisi sayesinde sağlar. @Getter ve @Setter da aynı işlevi vermektedir.
@MappedSuperclass //MappedSuperclass diğer classlarda extends edilebilmesini sağlıyor.
public abstract class BaseEntity implements Serializable { //Serializable nesnenin networkten taşınabilmesi veya diske yazılabilmesi özelliğini sağlar.
    //kimin hangi tarihte eklediği bilgisini tutan com.selind.issuemanagementsystem.entity
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(name = "created_by",length = 100)
    private String createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updateAt;
    @Column(name = "updated_by",length = 100)
    private String updateBy;
    @Column(name = "status")
    private Boolean status;

}
