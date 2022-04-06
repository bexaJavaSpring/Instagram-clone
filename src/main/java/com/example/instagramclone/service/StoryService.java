package com.example.instagramclone.service;

import com.example.instagramclone.entity.Attachment;
import com.example.instagramclone.entity.Comment;
import com.example.instagramclone.entity.Story;
import com.example.instagramclone.entity.User;
import com.example.instagramclone.payload.ApiResponse;
import com.example.instagramclone.payload.StoryDTO;
import com.example.instagramclone.repository.AttachmentRepository;
import com.example.instagramclone.repository.CommentRepository;
import com.example.instagramclone.repository.StoryRepository;
import com.example.instagramclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StoryService {

    @Autowired
    StoryRepository storyRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    public ApiResponse save(StoryDTO dto) {
        Story story=new Story();

        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        if (optionalUser.isPresent()) {
            story.setName(dto.getName());
            story.setUser(optionalUser.get());
            List<Comment> commentList = commentRepository.findAllById(dto.getCommentIds());
            Optional<Attachment> optionalAttachment = attachmentRepository.findById(dto.getAttachmentId());

            story.setAttachment(optionalAttachment.get());
            Story save = storyRepository.save(story);
            return new ApiResponse("Added!",true,save);
        }
       return new ApiResponse("No Added!",false);
    }
}
