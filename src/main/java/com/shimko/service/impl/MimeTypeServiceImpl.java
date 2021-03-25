package com.shimko.service.impl;

import com.shimko.domain.MimeType;
import com.shimko.repository.MimeTypeRepository;
import com.shimko.service.MimeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 20:07
 */

@Service
@Transactional
public class MimeTypeServiceImpl implements MimeTypeService {

    private MimeTypeRepository mimeTypeRepository;

    @Autowired
    public MimeTypeServiceImpl(final MimeTypeRepository mimeTypeRepository) {
        this.mimeTypeRepository = mimeTypeRepository;
    }

    @Override
    public MimeType findOrCreate(final String sysname) {

        if(mimeTypeRepository.countBySysname(sysname) > 0) {

            return mimeTypeRepository.findBySysname(sysname);
        } else {

            final MimeType mimeType = new MimeType(sysname);

            mimeTypeRepository.save(mimeType);

            return mimeType;
        }
    }
}
