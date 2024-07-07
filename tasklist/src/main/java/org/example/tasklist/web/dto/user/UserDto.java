package org.example.tasklist.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.tasklist.web.dto.validation.IOnCreate;
import org.example.tasklist.web.dto.validation.IOnUpdate;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @NotNull(message = "Id must be not null", groups = IOnUpdate.class)
    private Long id;

    @NotNull(message = "Name must be not null", groups = {IOnUpdate.class, IOnCreate.class})
    @Length(max = 255, message = "Max len is 255", groups = {IOnUpdate.class, IOnCreate.class})
    private String name;

    @NotNull(message = "Username must be not null", groups = {IOnUpdate.class, IOnCreate.class})
    @Length(max = 255, message = "Max len is 255", groups = {IOnUpdate.class, IOnCreate.class})
    private String username;

    //@NotNull(message = "Pass must be not null", groups = {IOnUpdate.class, IOnCreate.class})
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //private String pass;

    @NotNull(message = "Pass confirmation must be not null", groups = {IOnUpdate.class, IOnCreate.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passConfirm;
}
