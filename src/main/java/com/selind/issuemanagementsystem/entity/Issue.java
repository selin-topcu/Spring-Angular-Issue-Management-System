package com.selind.issuemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //Veritabanın da bir tabloya karşılık geleceğini ve bir ORM olduğunu belirtmek için Entity kullanılır.
@EqualsAndHashCode
@Table(name="issue")
public class Issue extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING) //enum türündeki veritabanını tipleri enumerated ile tutulur. ORDINAL ile tutulursa karmaşıklığa sebep olabilir, index sıra numarasına göre kontrol sağlar. Sonradan ekleme yapılırsa problem yaratabilir bu yüzden String kullanılır.
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)//ManyToOne birden çok issue classı bir user'a bağlanılabilir demektir. optional=true bir kullanıcıya atanılmasa da olur anlamına gelir.FetchType.LAZY sadece bu kayıt seçildiğinde getter metodu çağırılacak demektir. EAGER ise yük oluşturabilir.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
}
