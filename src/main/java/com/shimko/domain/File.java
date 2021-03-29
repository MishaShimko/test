package com.shimko.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 22:36
 */

@Data
@Entity
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    /**
     * Данные
     */
    @Column(name = "data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FileInfo fileInfo;

    public File(final byte[] data) {
        this.data = data;
    }
}
