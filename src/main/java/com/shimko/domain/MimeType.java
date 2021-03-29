package com.shimko.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 22:29
 */

@Data
@Entity
@Table(name = "mime_types")
@AllArgsConstructor
@NoArgsConstructor
public class MimeType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    /**
     * Системное наименование
     */
    @Column(name = "sysname")
    private String sysname;

    @OneToMany
    @PrimaryKeyJoinColumn
    private Set<FileInfo> fileInfo;


    public MimeType(final String sysname) {
        this.sysname = sysname;
    }
}
