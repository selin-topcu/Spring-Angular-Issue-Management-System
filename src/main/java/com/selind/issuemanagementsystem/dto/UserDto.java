package com.selind.issuemanagementsystem.dto;

public class UserDto {
    private Long id; //IssueDto üzerinden ulaşılabilmesi için oluşturuldu. Direk IssueDto üzerinden ulaşıldığında kullanıcının şifresine de ulaşılabilirdi bu yüzden buradan ulaşıldı.
    private String nameSurname;
}
