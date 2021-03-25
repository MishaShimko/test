package com.shimko.service;

import com.shimko.domain.MimeType;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 20:07
 */
public interface MimeTypeService {

    MimeType findOrCreate(final String sysname);

}
