package com.example.library.mapper;

import com.example.library.dto.ReaderDto;
import com.example.library.entity.Reader;
import org.springframework.stereotype.Component;

@Component
public class ReaderDtoMapper {

    public static ReaderDto toReaderDto(Reader reader) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setId(reader.getId());
        readerDto.setFullName(reader.getFullName());
        readerDto.setEmail(reader.getEmail());
        return readerDto;
    }

    public static Reader toReader(ReaderDto readerDto) {
        Reader reader = new Reader();
        reader.setId(readerDto.getId());
        reader.setFullName(readerDto.getFullName());
        reader.setEmail(readerDto.getEmail());
        return reader;
    }


}