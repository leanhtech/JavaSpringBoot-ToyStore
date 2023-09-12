package com.product.toystore.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class Image {
	
	public String saveImage(MultipartFile image) throws IOException {
	    String fileName = StringUtils.cleanPath(image.getOriginalFilename());
	    Path uploadPath = Paths.get("upload/image");

	    if (!Files.exists(uploadPath)) {
	        Files.createDirectories(uploadPath);
	    }

	    try (InputStream inputStream = image.getInputStream()) {
	        Path filePath = uploadPath.resolve(fileName);
	        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        return filePath.toString();
	    } catch (IOException e) {
	        throw new IOException("Failed to save image: " + fileName, e);
	    }
	}

}
