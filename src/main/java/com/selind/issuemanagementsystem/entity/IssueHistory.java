package com.selind.issuemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "issue_history")
public class IssueHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Issue issue;

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
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;

}
