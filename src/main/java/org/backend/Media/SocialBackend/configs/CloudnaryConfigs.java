package org.backend.Media.SocialBackend.configs;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudnaryConfigs {
    @Bean
    public Cloudinary getCloudnary(){
        Map<String,String> setup = new HashMap<>();
        setup.put("cloud_name","dfmwjqwdb");
        setup.put("api_key","157332283436348");
        setup.put("api_secret","7QcQwJAxSR9JGr8puzmyPUhj34k");
        return  new Cloudinary(setup);
    }
}
