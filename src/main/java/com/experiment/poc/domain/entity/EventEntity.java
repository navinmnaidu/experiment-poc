package com.experiment.poc.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Vikram Purohit
 *
 */
@Entity
@Table(name="event")
public class EventEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="description", length = 100)
    private String description;
    
    @Column(name="createdBy", nullable = false)
    private String createdBy; //TODO: change this to person reference?
    
    @OneToMany
    private Set<PersonEntity> participants;
}
