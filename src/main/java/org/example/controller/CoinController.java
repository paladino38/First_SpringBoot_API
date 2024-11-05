package org.example.controller;


import org.example.entity.coin;
import org.example.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@RestController
@RequestMapping("/coin")
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;



    @GetMapping()
    public ResponseEntity get(){
        return new ResponseEntity<>(coinRepository.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity get(@PathVariable String name){
       try{
           return new ResponseEntity<>(coinRepository.getByName(name), HttpStatus.OK);
       }catch (Exception error){
           return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @PutMapping()
    public ResponseEntity put (@RequestBody coin Coin){
        try{
            Coin.setDateTime(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(coinRepository.update(Coin), HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        try{
            return null; //new ResponseEntity<>(coinRepository.remove(id), HttpStatus.OK);
        }catch(Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping()
    public ResponseEntity post(@RequestBody coin Coin){
        try{
            Coin.setDateTime(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(coinRepository.insert(Coin), HttpStatus.CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

