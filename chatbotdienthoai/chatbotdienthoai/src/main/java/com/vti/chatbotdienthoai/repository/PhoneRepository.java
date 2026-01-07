package com.vti.chatbotdienthoai.repository;
import com.vti.chatbotdienthoai.model.Phone;

import java.util.List;
public interface PhoneRepository extends com.vti.chatbotdienthoai.repository.MongoRepository<Phone, String> {
    List<Phone> findByPurpose(String purpose);
}