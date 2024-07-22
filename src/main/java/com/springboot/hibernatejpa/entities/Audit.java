package com.springboot.hibernatejpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  
  public Audit() {}

  @PrePersist
  public void prePersist() {
    System.out.println("Before persisting data.");
    this.createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    System.out.println("Before updating data.");
    this.updatedAt = LocalDateTime.now();
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
  
  @Override
  public String toString() {
    return "Audit [createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
  }
}
