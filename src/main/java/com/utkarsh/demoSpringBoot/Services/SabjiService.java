package com.utkarsh.demoSpringBoot.Services;

import com.utkarsh.demoSpringBoot.Dao.SabjiRepo;
import com.utkarsh.demoSpringBoot.Models.Sabji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SabjiService {
    @Autowired
    SabjiRepo repo;

    public List<Sabji> getSabjis() {
        return repo.findAll();
    }

    public Sabji addSabji(Sabji sabji, MultipartFile imageFile) throws IOException {
        sabji.setImageName(imageFile.getOriginalFilename());
        sabji.setImageType(imageFile.getContentType());
        sabji.setImageData(imageFile.getBytes());

        return repo.save(sabji);
    }


    public byte[] getImage(String imageName) {
        Optional<Sabji> sabji = repo.findByImageName(imageName);

        if (sabji.isPresent() && sabji.get().getImageData() != null) {
            return sabji.get().getImageData(); // ✅ Return only the byte array
        }
        return null; // ✅ Return null if the image is not found
    }


}