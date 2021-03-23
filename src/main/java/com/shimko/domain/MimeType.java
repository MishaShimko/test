package com.shimko.domain;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 22:29
 */

@Entity
@Table(name = "mime_types")
public class MimeType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * Название типа файла
     */
    @Column(name = "name")
    private String name;

    /**
     * Системное наименование
     */
    @Column(name = "sysname")
    private String sysname;

    public MimeType(final Long id, final String name, final String sysname) {
        this.id = id;
        this.name = name;
        this.sysname = sysname;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(final String sysname) {
        this.sysname = sysname;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MimeType)) return false;
        final MimeType mimeType = (MimeType)o;
        return Objects.equal(id, mimeType.id)
            && Objects.equal(name, mimeType.name)
            && Objects.equal(sysname, mimeType.sysname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, name, sysname
        );
    }

    @Override
    public String toString() {
        return "MimeType{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", sysname='" + sysname + '\''
            + '}';
    }
}
