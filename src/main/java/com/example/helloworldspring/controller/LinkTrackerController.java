package com.example.helloworldspring.controller;

import com.example.helloworldspring.exception.URLInvalidaException;
import com.example.helloworldspring.service.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/link")
public class LinkTrackerController {

    @Autowired
    LinkTrackerService linkTrackerService;

    @PostMapping(path = "/{link}")
    public ResponseEntity<?> registraURL(@PathVariable String link) throws URLInvalidaException {
         return  linkTrackerService.registraURL(link);
    }

    @GetMapping(path = "/{linkid}")
    public ResponseEntity<Void> redirecionaLink(@PathVariable String linkid){
        String link = (String) linkTrackerService.getLink(linkid).getBody();
        String newUrl = "http://"+link;
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, newUrl).build();
    }

    @GetMapping(path = "/metricas/{linkid}")
    public ResponseEntity<?> quantidadeAcessos(@PathVariable String linkid){
        return linkTrackerService.getQuantidadeAcessos(linkid);
    }
}
