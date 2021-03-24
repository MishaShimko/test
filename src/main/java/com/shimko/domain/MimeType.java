package com.shimko.domain;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    private Integer id;

    /**
     * Системное наименование
     */
    @Column(name = "sysname")
    private String sysname;

    @OneToOne
    private FileInfo fileInfo;

    public MimeType() {
    }

    public MimeType(final String sysname) {
        this.sysname = sysname;
    }

    public MimeType(final Integer id, final String sysname, final FileInfo fileInfo) {
        this.id = id;
        this.sysname = sysname;
        this.fileInfo = fileInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(final String sysname) {
        this.sysname = sysname;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(final FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MimeType)) return false;
        final MimeType mimeType = (MimeType)o;
        return Objects.equal(id, mimeType.id)
            && Objects.equal(sysname, mimeType.sysname)
            && Objects.equal(fileInfo, mimeType.fileInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, sysname, fileInfo
        );
    }

    @Override
    public String toString() {
        return "MimeType{"
            + "id=" + id
            + ", sysname='" + sysname + '\''
            + ", fileInfo=" + fileInfo
            + '}';
    }
}
