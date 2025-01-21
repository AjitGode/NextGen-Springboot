package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.ContactForm;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    ContactForm addContactForm(ContactForm contactForm);

    List<ContactForm> getAllContactForm();

    Optional <ContactForm> getContactFormById(int id);

    void deleteContactForm(int id);
}
