package com.example.library.service.impl;

import com.example.library.dto.RandomReaderResponse;
import com.example.library.dto.ReaderDto;
import com.example.library.dto.ReaderUser;
import com.example.library.entity.Reader;
import com.example.library.mapper.ReaderDtoMapper;
import com.example.library.service.ReaderClient;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderClientService {
    private final ReaderClient readerClient;
    private final ReaderService readerService;
    private ReaderDtoMapper readerDtoMapper;


    public Reader saveReaderThroughApi() {
        RandomReaderResponse randomReaderResponse = readerClient.getRandomReader();


        ReaderDto readerDto = new ReaderDto();
        readerDto.setEmail(randomReaderResponse.getResults().get(0).getEmail());
        readerDto.setFullName(randomReaderResponse.getResults().get(0).getName().getFirst() + " " +
                randomReaderResponse.getResults().get(0).getName().getLast());


        return readerService.createReader(readerDtoMapper.toReader(readerDto));
    }


}
