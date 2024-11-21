package com.projects.kayan_API.Services;

import com.projects.kayan_API.Entities.ContactUsEntity;
import com.projects.kayan_API.Entities.UserEntity;
import com.projects.kayan_API.Models.ContactUsDTO;
import com.projects.kayan_API.Repositories.ContactUsRepoInt;
import com.projects.kayan_API.Repositories.UserRepoInt;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.management.relation.RelationNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ContactUsService implements ContactUsServiceInt {
    private final ContactUsRepoInt contactUsRepo;
    private final UserRepoInt userRepo;
    private final ModelMapper mapper=new ModelMapper();


    @Override
    public ContactUsDTO sendMessage(ContactUsDTO contact) {
        UserEntity user=userRepo.findById(contact.getUserId()).get();//orElseThrow(()->new RuntimeException("user not found"));
        ContactUsEntity contactUs ;
        if (contact.getMessageType()!=null &contact.getContent()!=null &contact.getUserId()!=null)
        {
            contactUs=new ContactUsEntity();
            contactUs.setMessageType(contact.getMessageType());
            contactUs.setContent(contact.getContent());
            contactUs.setUserId(user);
            return mapper.map(contactUsRepo.save(contactUs), ContactUsDTO.class);
        }
        return null;
    }

    @Override
    public List<ContactUsDTO> getAllMessages() {

//        List<ContactUsDTO> contactUsDTOs = new ArrayList<>();
//
//         contactUsRepo.findAll().forEach(
//                contact->{
//                    contactUsDTOs.add(mapper.map(contact, ContactUsDTO.class));
//
//                });
//
//        return  contactUsDTOs;
        return contactUsRepo.findAll().stream().map(contact->mapper.map(contact, ContactUsDTO.class)).collect(Collectors.toList());

    }
}
