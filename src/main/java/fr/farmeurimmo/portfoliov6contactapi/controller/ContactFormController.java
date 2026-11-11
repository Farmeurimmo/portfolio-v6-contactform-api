package fr.farmeurimmo.portfoliov6contactapi.controller;

import fr.farmeurimmo.portfoliov6contactapi.dto.ContactFormRequest;
import fr.farmeurimmo.portfoliov6contactapi.service.ContactFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/form/contact")
@RequiredArgsConstructor
@Tag(name = "Contact Form Controller", description = "Controller for handling contact form submissions")
public class ContactFormController {

    private final ContactFormService contactFormService;

    @Operation(summary = "Submit contact form", description = "Endpoint to submit contact form data")
    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactFormRequest request) {
        return contactFormService.handleContactFormSubmission(request);
    }
}
