package com.example.projectmrsisa.service;

import com.example.projectmrsisa.model.*;
import com.example.projectmrsisa.repository.FishingInstructorRepository;
import com.example.projectmrsisa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FishingInstructorRepository fishingInstructorRepository;

    public List<User> findUsersByActivatedStatus(Boolean isActivated, Boolean isDeleted){
        return userRepository.findUsersByActivatedStatus(isActivated, isDeleted);
    }

    public FishingInstructor findFishingInstructorById(Integer id){
        return userRepository.findFishingInstructorById(id);
    }

    public ShipOwner findShipOwnerById(Integer id){
        return userRepository.findShipOwnerById(id);
    }

    public RetreatOwner findRetreatOwnerById(Integer id){
        return userRepository.findRetreatOwnerById(id);
    }

    public User findUserById(Integer id){
        return userRepository.findUserById(id);
    }

    public void updateUserActivatedStatusById(Integer id){
        userRepository.updateUserActivatedStatusById(id);
    }

    public void updateUserDeletedStatusById(Integer id){
        userRepository.updateUserDeletedStatusById(id);
    }

    public RegistrationReasoning findRegistrationReasoningByUserId(User user){
        return userRepository.findRegistrationReasoningByUser(user);
    }

    public FishingInstructor findFishingInstructorByEmail(String email){
        return fishingInstructorRepository.findFishingInstructorByEmail(email);
    }
}
