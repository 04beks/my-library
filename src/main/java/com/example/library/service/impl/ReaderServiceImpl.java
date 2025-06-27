package com.example.library.service.impl;

import com.example.library.entity.Reader;
import com.example.library.repository.ReaderRepository;
import com.example.library.service.ReaderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {

   private  final ReaderRepository readerRepository;

    @Override
    public Reader createReader(Reader reader) {
       return readerRepository.save(reader);
   }

   @Override
   public Reader getRearById(Long id) {
     return readerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reader not found"));
   }
   @Override
   public List<Reader> getAllReaders() {
       return readerRepository.findAll();
   }
   @Override
   public Reader updateReader(Long id, Reader reader) {
       Reader newReader = getRearById(id);
       newReader.setId(reader.getId());
       newReader.setFullName(reader.getFullName());
       newReader.setEmail(reader.getEmail());
       return readerRepository.save(newReader);
   }
   @Override
   public void deleteReader(Long id) {
     Reader reader = getRearById(id);
     readerRepository.delete(reader);
   }

}
