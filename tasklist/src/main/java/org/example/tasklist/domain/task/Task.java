package org.example.tasklist.domain.task;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {

    private Long id;
    private String title;
    private String desc;
    private Status status;
    private LocalDateTime expDate;

}
