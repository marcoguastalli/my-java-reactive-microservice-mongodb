package net.marco27.api.rx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.marco27.api.rx.domain.JavaReactiveBean;
import net.marco27.api.rx.repository.JavaReactiveRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class JavaReactiveService {

    private final JavaReactiveRepository javaReactiveRepository;

    @Autowired
    public JavaReactiveService(JavaReactiveRepository javaReactiveRepository) {
        this.javaReactiveRepository = javaReactiveRepository;
    }

    public Flux<JavaReactiveBean> findAll() {
        return javaReactiveRepository.findAll();
    }

    public Mono<JavaReactiveBean> findById(String id) {
        return javaReactiveRepository.findById(id);
    }

    public Mono<JavaReactiveBean> save(JavaReactiveBean javaReactiveBean) {
        return javaReactiveRepository.save(javaReactiveBean);
    }

    public Mono<Void> delete(JavaReactiveBean javaReactiveBean) {
        return javaReactiveRepository.delete(javaReactiveBean);
    }
}
