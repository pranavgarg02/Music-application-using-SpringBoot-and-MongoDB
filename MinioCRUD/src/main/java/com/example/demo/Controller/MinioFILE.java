package com.example.demo.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import io.minio.messages.Bucket;
//import io.minio.messages.Item;

@RestController
@RequestMapping("/server")
public class MinioFILE {
	MinioClient minioClient = MinioClient.builder().endpoint("http://localhost:9000/").credentials("minioadmin", "minioadmin").build();
	
	@GetMapping("/get/allbuckets")
	public List<String> getallBuckets(){
	try {
		
        List<Bucket> li = minioClient.listBuckets();
//        System.out.println(li.toString());
//        System.out.println("size "+li.size());
//        System.out.println(li.get(0));
        ArrayList<String> arr = new ArrayList<>();
        for(Bucket b : li) {
        	arr.add(b.name());
        }
       return arr;
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
	}
	
	
	@PostMapping("/upload")
	public void uploadfile(@RequestParam("file") MultipartFile file )throws IOException , Exception { // InsufficientDataException ,InvalidArgumentException , InternalException,ErrorResponseException{
		try {
			if(minioClient.bucketExists(BucketExistsArgs.builder().bucket("pranav").build()))
			{
			System.out.println("Bucket name pranav already exists");
			}
			else minioClient.makeBucket(MakeBucketArgs.builder().bucket("pranav").build());
			System.out.println("till here");
			
		String contentType = file.getContentType(); 
			
	minioClient.putObject(PutObjectArgs.builder().bucket("pranav").object(file.getOriginalFilename()).stream(file.getInputStream(), file.getSize(), -1).contentType(contentType).build());
			
			System.out.println(
			          "'download.jfif' is successfully uploaded as "
			              + "object 'download.jfif' to bucket 'pranav'.");
		}
	 catch (IOException e) {
	            throw new IllegalStateException("The file cannot be read", e);
	            }
		catch(Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("Something is wrong " , e);
		}
	}
		@GetMapping("/getFile/{fileName}/{content}")
		public ResponseEntity<ByteArrayResource> getObject(@PathVariable String fileName , @PathVariable String content) throws MinioException , IOException ,Exception {
				InputStream stream = minioClient.getObject(GetObjectArgs.builder().bucket("pranav").object(fileName+"."+content).build());
				
				byte arr[] = IOUtils.toByteArray(stream);
				ByteArrayResource resource = new ByteArrayResource(arr);
				return ResponseEntity.ok().body(resource);
}
}



