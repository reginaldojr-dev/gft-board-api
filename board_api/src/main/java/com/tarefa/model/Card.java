package com.tarefa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false)
    private String title;

    @Size(max = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.TODO;

    @NotBlank
    @Size(max = 60)
    @Column(nullable = false)
    private String board = "default";

    public Card() {}

    public Card(String title, String description, Status status, String board) {
        this.title = title;
        this.description = description;
        this.status = (status != null ? status : Status.TODO);
        this.board = (board != null && !board.isBlank() ? board : "default");
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Status getStatus() { return status; }
    public String getBoard() { return board; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(Status status) { this.status = status; }
    public void setBoard(String board) { this.board = board; }
}
