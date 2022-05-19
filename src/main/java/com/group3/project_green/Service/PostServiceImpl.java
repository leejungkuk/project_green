package com.group3.project_green.Service;

import com.group3.project_green.DTO.PostDTO;
import com.group3.project_green.entity.Post;
import com.group3.project_green.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostServiceImpl implements PostService{
    private final PostRepository repository;
    @Override
    public List<PostDTO> getList() {

        List<Post> result = repository.findAll();
        // 리스트를 뽑아온다
        List<PostDTO> dtoList = new ArrayList<>();
        for(Post post : result){
            dtoList.add(entityToDTO(post));
        }
        // 뽑아온 리스트를 DTO 리스트로 바꾼다 (default 메서드이용)

        // DTO 리스트를 반환한다.
        return dtoList;
    }
//
//    @Override
//    public List<PostDTO> getListByAccom() {
//
//        List<Post> result = repository.findbyAccom();
//
//        List<PostDTO> dtoList = new ArrayList<>();
//        for(Post post : result){
//            dtoList.add(entityToDTO(post));
//            System.out.println("===================");
//            System.out.println(post);
//            System.out.println("===================");
//        }
//        return  dtoList;
//    }
//
//    @Override
//    public List<PostDTO> getListByFood() {
//        List<Post> result = repository.findbyFood();
//        List<PostDTO> dtoList = new ArrayList<>();
//        for(Post post : result){
//            dtoList.add(entityToDTO(post));
//            System.out.println("===================");
//            System.out.println(post);
//            System.out.println("===================");
//        }
//
//        return dtoList;
//    }

//    @Override
//    public List<PostDTO> getListBysights() {
//        List<Post> result = repository.findbysights();
//
//        List<PostDTO> dtoList = new ArrayList<>();
//        for(Post post : result){
//            dtoList.add(entityToDTO(post));
//            System.out.println("===================");
//            System.out.println(post);
//            System.out.println("===================");
//        }
//        return dtoList;
//    }


    @Override
    public PostDTO get(Long pno) {
        PostDTO result = entityToDTO(repository.getById(pno));
        return result;
    }
}