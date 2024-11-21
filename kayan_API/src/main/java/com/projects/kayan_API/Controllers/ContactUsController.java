package com.projects.kayan_API.Controllers;

import com.projects.kayan_API.Models.ContactUsDTO;
import com.projects.kayan_API.Services.ContactUsServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ContactUsController {
    private final ContactUsServiceInt contactUsService;


    @PostMapping("/send")
    private ContactUsDTO sendMessage(@RequestBody  ContactUsDTO message)
    {
        return contactUsService.sendMessage(message);
    }

    @GetMapping("/massageslist")
    private List<ContactUsDTO> getAllMessages()
    {
        return contactUsService.getAllMessages();
    }
}
