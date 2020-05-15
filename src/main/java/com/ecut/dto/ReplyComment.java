package com.ecut.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyComment {
    private Long id;
    private String content;
    private String useremail;
    private String username;
    private Long blogId;
    private String commentnickname;
    private Long parentid;
    private Long commentid;
}
