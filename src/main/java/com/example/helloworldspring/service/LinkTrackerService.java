package com.example.helloworldspring.service;

import com.example.helloworldspring.exception.LinkNotFoundException;
import com.example.helloworldspring.exception.URLInvalidaException;
import com.example.helloworldspring.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkTrackerService {

    private static Map<String, String> links = new HashMap<>();
    private static Map<String, Integer> acessos = new HashMap<>();
    private static int contador =0;

    public ResponseEntity<?> registraURL(String url) throws URLInvalidaException {
        if(validaURL(url)){
            String linkId = geraLinkId();
            links.put(linkId, url);
            acessos.put(linkId, 0);
            System.out.println(links.toString());
            return new ResponseEntity<>(linkId, HttpStatus.OK);
        }
        else{
            return handleException(new URLInvalidaException(url));
        }
    }

    public ResponseEntity<?> getLink(String linkId){
        if(links.get(linkId).isEmpty()){
            return handleException(new LinkNotFoundException(linkId));
        }
        acessos.put(linkId, acessos.get(linkId) + 1);
        return new ResponseEntity<>(links.get(linkId), HttpStatus.OK);
    }

    public ResponseEntity<?> getQuantidadeAcessos(String linkId){
        if(!links.containsKey(linkId)){
            return handleException(new LinkNotFoundException(linkId));
        }
        return new ResponseEntity<>(acessos.get(linkId), HttpStatus.OK);
    }

    private boolean validaURL(String url)throws URLInvalidaException{
        return url.matches("[a-z]{2,}.com(.[a-z]{2})?");
    }

    private String geraLinkId(){
        ++contador;
        return Integer.toString(contador);
    }

    @ExceptionHandler(URLInvalidaException.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e){
        if(e.getClass().equals(URLInvalidaException.class)){
            ErrorDTO errorDTO = new ErrorDTO("Invalid URL", "The URL " + e.getMessage() + " is invalid.");

            return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
        }
        else{
            ErrorDTO errorDTO = new ErrorDTO("URL Not Found", "The URL with key " + e.getMessage() + " not found.");
            return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        }

    }
}
