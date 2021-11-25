package com.cvirtual.worker.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_userrole")
@EqualsAndHashCode
public class UserRole implements Serializable {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long roleId;

    private String roleName;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
