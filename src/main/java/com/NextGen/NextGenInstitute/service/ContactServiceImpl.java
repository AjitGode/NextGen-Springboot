package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.ContactForm;
import com.NextGen.NextGenInstitute.repository.Contactrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private Contactrepository contactrepository;

    @Override
    public ContactForm addContactForm(ContactForm contactForm) {
        return contactrepository.save(contactForm);
    }

    @Override
    public List<ContactForm> getAllContactForm() {
        return contactrepository.findAll();
    }

    @Override
    public Optional<ContactForm> getContactFormById(int id) {
        return contactrepository.findById(id);
    }

    @Override
    public void deleteContactForm(int id) {
      contactrepository.deleteById(id);
    }
}
