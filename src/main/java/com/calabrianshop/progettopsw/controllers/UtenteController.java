package com.calabrianshop.progettopsw.controllers;


import com.calabrianshop.progettopsw.entities.Utente;
import com.calabrianshop.progettopsw.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4300"})
public class UtenteController {

    private byte[] bytes;

    @Autowired
    private UtenteService utenteService;


    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public List<Utente> allUtente(){
        return utenteService.showAllUtente();}



    @CrossOrigin(origins = {"http://localhost:4200"})
    @PostMapping("/add")
    //@PreAuthorize("hasAuthority('Admin')")
    public void addUtente(@RequestBody Utente u){
        System.out.println(u);
        utenteService.addUtente(u);
    }
     /*@PostMapping("/reg")
    public void addUtenteAuth(@AuthenticationPrincipal OidcUser user){
        utenteService.accounting(user);*/

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile")MultipartFile file) throws IOException {
        this.bytes=file.getBytes();
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public void deleteUtente(@PathVariable("id") int id){
        utenteService.deleteUtentebyId(id);
    }


}