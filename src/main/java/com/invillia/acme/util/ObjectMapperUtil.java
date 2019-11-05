package com.invillia.acme.util;

import org.modelmapper.ModelMapper;

public final class ObjectMapperUtil {

    public static <T> T convert(Object object, Class<T> clazz) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, clazz);
    }

}
