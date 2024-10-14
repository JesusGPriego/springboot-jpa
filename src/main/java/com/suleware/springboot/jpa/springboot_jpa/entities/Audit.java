package com.suleware.springboot.jpa.springboot_jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Audit {

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

     @PrePersist
    public void prePersist() {
        System.out.println("prePersist lifecicle event");
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("preUPdate lifecicle event");
        this.updatedAt = LocalDateTime.now();
    }
}
