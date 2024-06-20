package org.backend.Media.SocialBackend.service;

import org.backend.Media.SocialBackend.Repository.PostRepository;
import org.backend.Media.SocialBackend.entities.Post;
import org.backend.Media.SocialBackend.entities.USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {

        @Autowired
        private PostRepository postRepository;
        @Autowired
        private CloudnaryService cloudnaryService;
        @Autowired
        private UserService userService;
        public Post save(Post post, MultipartFile file,String UserName) throws IOException {
            USER user = userService.findByUserName(UserName);
            Map map = cloudnaryService.postImage(file);
            String url = (String) map.get("url");
            post.setUrl_to_Image(url);
            post.setUserName(UserName);
            Post save = postRepository.save(post);
            user.getUsers_posts().add(save);
            userService.save(user);
            return save;
        }

        public List<Post> findAll(){
            return postRepository.findAll();
        }

        public  void deletuser(String id){
            postRepository.deleteById(id);
        }

        public Optional<Post> findById(String id){
            return postRepository.findById(id);
        }

        public List<Post> findByUserName(String name){
            return postRepository.findByUserName(name);
        }
}