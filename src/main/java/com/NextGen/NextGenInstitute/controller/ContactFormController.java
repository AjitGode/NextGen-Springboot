package com.NextGen.NextGenInstitute.controller;

import com.NextGen.NextGenInstitute.Entity.ContactForm;
import com.NextGen.NextGenInstitute.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactform")
@CrossOrigin(origins = "*")
public class ContactFormController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactForm addContactForm(@RequestBody ContactForm contactForm){
        return contactService.addContactForm(contactForm);
    }

    @GetMapping
    public List<ContactForm> getAllContactForm(){
        return contactService.getAllContactForm();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactForm> getContactFormById(@PathVariable int id){
        return contactService.getContactFormById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContactForm(@PathVariable int id){
        contactService.deleteContactForm(id);
        return ResponseEntity.ok("Contact form delete successfully!!");
    }
}
