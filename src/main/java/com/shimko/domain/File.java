package com.shimko.domain;

import com.google.common.base.Objects;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long id;

    /**
     * Данные
     */
    @Column(name = "name")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

    /**
     * Флаг на удаление
     */
    @Column(name = "sysname")
    private Boolean toDelete;

    public File(final Long id, final byte[] data, final Boolean toDelete) {
        this.id = id;
        this.data = data;
        this.toDelete = toDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    public Boolean getToDelete() {
        return toDelete;
    }

    public void setToDelete(final Boolean toDelete) {
        this.toDelete = toDelete;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        final File file = (File)o;
        return Objects.equal(id, file.id)
            && Objects.equal(data, file.data)
            && Objects.equal(toDelete, file.toDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, data, toDelete
        );
    }

    @Override
    public String toString() {
        return "File{"
            + "id=" + id
            + ", data=" + Arrays.toString(data)
            + ", toDelete=" + toDelete
            + '}';
    }
}
