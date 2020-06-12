package com.lkreski.cho.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class SystemEvents {
    @Column
    @Id
    private Long sysID;
    @Column
    private LocalDate timeStamp;
    @Column
    private String eventType;

    @Column
    private String userName;
}
