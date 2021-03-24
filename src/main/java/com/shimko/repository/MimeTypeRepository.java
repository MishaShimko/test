package com.shimko.repository;

import com.shimko.domain.MimeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shimko
 * @date 24.03.2021
 * @time 23:22
 */

@Repository
public interface MimeTypeRepository extends JpaRepository<MimeType, Integer> {

    MimeType findBySysname(final String sysname);

}
