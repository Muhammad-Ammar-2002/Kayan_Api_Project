package com.projects.kayan_API.Services;

import com.projects.kayan_API.Models.ContactUsDTO;

import java.util.List;

public interface ContactUsServiceInt {

   ContactUsDTO sendMessage(ContactUsDTO contact);
   List<ContactUsDTO> getAllMessages();

}
