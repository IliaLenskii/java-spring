package org.example.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.tasklist.domain.task.Status;
import org.example.tasklist.web.dto.validation.IOnCreate;
import org.example.tasklist.web.dto.validation.IOnUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    @NotNull(message = "Id must be not null", groups = IOnUpdate.class)
    private Long id;

    @NotNull(message = "Title must be not null", groups = {IOnUpdate.class, IOnCreate.class})
    @Length(max = 255, message = "Max len is 255", groups = {IOnUpdate.class, IOnCreate.class})
    private String title;

    @Length(max = 255, message = "Desc len is 255", groups = {IOnUpdate.class, IOnCreate.class})
    private String desc;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expDate;
}
