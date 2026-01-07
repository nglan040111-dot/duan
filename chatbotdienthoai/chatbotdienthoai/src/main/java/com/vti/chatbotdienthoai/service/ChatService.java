package com.vti.chatbotdienthoai.service;
import com.vti.chatbotdienthoai.model.Phone;
import com.vti.chatbotdienthoai.repository.PhoneRepository;

import java.util.List;

public class ChatService {
    private final PhoneRepository phoneRepository;

    public ChatService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }
    public String handleChat(String message) {
        message = message.toLowerCase();

        if (message.contains("game")) {
            return recommend("game");
        }
        if (message.contains("chụp") || message.contains("camera")) {
            return recommend("camera");
        }
        if (message.contains("học") || message.contains("làm việc")) {
            return recommend("work");
        }
        return "Bạn muốn mua điện thoại để chơi game, chụp ảnh hay làm việc?";
    }

    private String recommend(String game) {
        String purpose = null;
        List<Phone> phones = phoneRepository.findByPurpose(purpose);
        if (phones.isEmpty()) {
            return "Chưa có điện thoại phù hợp.";
        }

        StringBuilder sb = new StringBuilder("Gợi ý cho bạn:\n");
        for (Phone p : phones) {
            sb.append("- ")
                    .append(p.getName())
                    .append(" | ")
                    .append(p.getPrice())
                    .append(" VNĐ\n");
        }
        return sb.toString();
    }

}
