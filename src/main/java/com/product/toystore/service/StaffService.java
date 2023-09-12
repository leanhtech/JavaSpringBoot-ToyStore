package com.product.toystore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.entity.Staff;
import com.product.toystore.repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(String staffId) {
        return staffRepository.findById(staffId);
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Optional<Staff> updateStaff(String staffId, Staff staff) {
        Optional<Staff> existingStaff = staffRepository.findById(staffId);
        if (existingStaff.isPresent()) {
            Staff updatedStaff = existingStaff.get();
            updatedStaff.setFirstName(staff.getFirstName());
            updatedStaff.setLastName(staff.getLastName());
            updatedStaff.setEmail(staff.getEmail());
            updatedStaff.setPhone(staff.getPhone());
            updatedStaff.setGender(staff.getGender());
            updatedStaff.setAddress(staff.getAddress());
            updatedStaff.setUserName(staff.getUserName());
            updatedStaff.setPassword(staff.getPassword());
            updatedStaff.setBirthday(staff.getBirthday());
            return Optional.of(staffRepository.save(updatedStaff));
        }
        return Optional.empty();
    }

    public void deleteStaff(String staffId) {
        staffRepository.deleteById(staffId);
    }
}
