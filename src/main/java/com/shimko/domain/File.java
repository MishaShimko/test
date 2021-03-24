package com.shimko.domain;

import com.google.common.base.Objects;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Arrays;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 22:36
 */

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    /**
     * Данные
     */
    @Column(name = "name")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

    @OneToOne
    private FileInfo fileInfo;

    public File() {
    }

    public File(final byte[] data) {
        this.data = data;
    }

    public File(final Integer id, final byte[] data, final FileInfo fileInfo) {
        this.id = id;
        this.data = data;
        this.fileInfo = fileInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(final byte[] data) {
        this.data = data;
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
        if (!(o instanceof File)) return false;
        final File file = (File)o;
        return Objects.equal(id, file.id)
            && Objects.equal(data, file.data)
            && Objects.equal(fileInfo, file.fileInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, data, fileInfo
        );
    }

    @Override
    public String toString() {
        return "File{"
            + "id=" + id
            + ", data=" + Arrays.toString(data)
            + ", fileInfo=" + fileInfo
            + '}';
    }
}
